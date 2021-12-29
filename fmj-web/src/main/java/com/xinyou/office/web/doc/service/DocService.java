package com.xinyou.office.web.doc.service;

import com.alibaba.fastjson.JSON;
import com.definesys.fnd.file.service.FndFileService;
import com.definesys.fnd.file.vo.FndFileVO;
import com.definesys.mpaas.common.exception.MpaasRuntimeException;
import com.definesys.mpaas.query.db.PageQueryResult;
import com.xinyou.office.web.config.AppConfiguration;
import com.xinyou.office.web.doc.eo.DocEO;
import com.xinyou.office.web.doc.vo.AttachmentVO;
import com.xinyou.office.web.doc.vo.DocStyle;
import com.xinyou.office.web.doc.vo.DocVO;
import com.xinyou.office.web.doc.dao.DocDao;
import com.definesys.mpaas.query.util.BeanUtil;
import com.xinyou.office.web.doc.vo.DocumentMergeVO;
import com.xinyou.office.web.template.service.TemplateService;
import com.xinyou.office.web.template.vo.TemplateVO;
import com.xinyou.office.web.util.HttpRequest;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;


/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2019/8/29 1:37 PM
 * @history: 1.2019/8/29 created by jianfeng.zheng
 */
@Service
public class DocService {

    @Autowired
    private DocDao docDao;

    @Autowired
    private FndFileService fileService;

    @Autowired
    private TemplateService templateService;

    @Autowired
    private AttachmentService attachmentService;

    @Autowired
    private AppConfiguration appConfiguration;

    /**
     * 查询公文
     *
     * @param searchText
     * @return
     */
    public PageQueryResult queryDoc(String searchText) {
        return docDao.queryDoc(searchText);
    }

    /**
     * 保存公文
     *
     * @param doc
     * @return
     */
    public Long apply(DocVO doc) {
        DocEO docEO = BeanUtil.convert(doc, DocEO.class);
        DocStyle style = null;
        if (docEO.getDocStyle() == null) {
            TemplateVO template = templateService.queryTemplateDetail(doc.getTemplateId());
            docEO.setDraftOrg(template.getDraftOrgTitle());
            docEO.setPrintOrg(template.getPrintOrg());
            style = JSON.parseObject(template.getStyle(), DocStyle.class);
            style.clearDisableText();
            style.getTitle().setText(docEO.getTitle());
            style.getToOrg().setText(docEO.getToOrg());
            style.getCcOrg().setText(docEO.getCcOrg());
            style.getDocCode().setText(docEO.getDocNo());
            style.setUrgentLevel(docEO.getUrgentLevel());
            style.setSecretLevel(docEO.getSecretLevel());
            style.getContent().setText(docEO.getContentText());
            style.getAttachment().setText("");
            docEO.setDocStyle(JSON.toJSONString(style));
        } else {
            style = JSON.parseObject(docEO.getDocStyle(), DocStyle.class);
        }
        List<AttachmentVO> attachments = attachmentService.queryAttachment(doc.getId());
        if (attachments != null && !attachments.isEmpty()) {
            StringBuffer text = new StringBuffer();
            for (AttachmentVO attachment : attachments) {
                if (text.length() > 0) {
                    text.append("\n");
                }
                text.append(attachment.getFileName());
            }
            style.getAttachment().setText(text.toString());
            docEO.setDocStyle(JSON.toJSONString(style));
        }
        return docDao.apply(docEO);
    }


    /**
     * 删除公文
     *
     * @param rowid
     * @return
     */
    public Integer deleteDoc(Long rowid) {
        return docDao.deleteDoc(rowid);
    }

    /**
     * 获取公文详情
     *
     * @param rowid
     * @return
     */
    public DocVO queryDocDetail(Long rowid) {
        return docDao.queryDocDetail(rowid);
    }

    /**
     * 从文件里抽取text文本
     *
     * @param fndFileVO
     * @return
     */
    public String extractDocumentContent(FndFileVO fndFileVO) {
        InputStream docInputStream = fileService.getFileInputStream(fndFileVO);
        docInputStream = FileMagic.prepareToCheckMagic(docInputStream);
        WordExtractor extractor = null;
        StringBuilder buf = new StringBuilder();
        try {
            if (FileMagic.valueOf(docInputStream) == FileMagic.OLE2) {
                extractor = new WordExtractor(docInputStream);
                String[] text = extractor.getParagraphText();
                for (String t : text) {
                    if (buf.length() > 0) {
                        buf.append("\n");
                    }
                    buf.append(t);
                }
            } else if (FileMagic.valueOf(docInputStream) == FileMagic.OOXML) {
                XWPFDocument doc = new XWPFDocument(docInputStream);
                List<XWPFParagraph> paragraphs = doc.getParagraphs();
                for(XWPFParagraph p:paragraphs){
                    if (buf.length() > 0) {
                        buf.append("\n");
                    }
                    buf.append(p.getText());
                }
            }
        } catch (IOException e) {
            throw new MpaasRuntimeException(e);
        }

        return buf.toString();
    }

    /**
     * 只对样式进行更新
     *
     * @param doc
     * @return
     */
    public void updateStyle(DocVO doc) {
        docDao.updateStyle(doc);
    }

    /**
     * 返回可打印html
     *
     * @param docId
     * @return
     */
    public String getPrintHtml(Long docId) {
        DocVO docVO = docDao.queryDocDetail(docId);
        return docVO.getFullHtml();
    }

    /**
     * 下载
     *
     * @param docId
     * @return
     */
    public String download(Long docId) {
        DocVO docVO = docDao.queryDocDetail(docId);
        DocumentMergeVO query = new DocumentMergeVO();
        query.addFile(appConfiguration.getHost() + "/doc/printHtml?docId=" + docId);
        List<AttachmentVO> attachments = docVO.getAttachments();
        if (attachments != null) {
            for (AttachmentVO item : attachments) {
                FndFileVO fileVO = fileService.queryFndFileDetail(item.getFileId().toString());
                query.addAttachment(appConfiguration.getHost() + "/fnd/file/download?docId=" + fileVO.getUuid());
            }
        }
        query.setOutputFilePath("\\\\Mac\\Home\\Downloads\\office\\" + docId + ".pdf");
        try {
            System.out.println(JSON.toJSONString(query));
            String body = HttpRequest.post(appConfiguration.getOfficeService() + "/pdf/merge")
                    .contentType("application/json")
                    .connectTimeout(2000)
                    .readTimeout(60000)
                    .send(JSON.toJSONString(query).getBytes("utf-8"))
                    .body();
            System.out.println("response==>" + body);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return appConfiguration.getHost() + "/doc/downloadPDF?docId=" + docId;
    }

    /**
     * 下载PDF
     *
     * @param docId
     * @return
     */
    public ResponseEntity<Resource> downloadPDF(Long docId) {
        DocVO docVO = docDao.queryDocDetail(docId);
        InputStreamResource resource = null;
        String originFileName = null;
        File file = new File("/Users/asan/Downloads/office/" + docId + ".pdf");
        try {
            InputStream fileInputStream = new FileInputStream(file);
            if (fileInputStream == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            resource = new InputStreamResource(fileInputStream);
            originFileName = new String(docVO.getTitle().getBytes("UTF-8"), "ISO8859_1");
        } catch (Exception e) {
            throw new MpaasRuntimeException("文件下载失败", e);
        }
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment;filename=" + originFileName)
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
    }
}
