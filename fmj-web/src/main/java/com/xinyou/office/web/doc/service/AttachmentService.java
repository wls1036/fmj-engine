package com.xinyou.office.web.doc.service;

import com.alibaba.fastjson.JSON;
import com.definesys.mpaas.query.db.PageQueryResult;
import com.xinyou.office.web.doc.dao.DocDao;
import com.xinyou.office.web.doc.eo.AttachmentEO;
import com.xinyou.office.web.doc.eo.DocEO;
import com.xinyou.office.web.doc.vo.AttachmentVO;
import com.xinyou.office.web.doc.dao.AttachmentDao;
import com.definesys.mpaas.query.util.BeanUtil;
import com.xinyou.office.web.doc.vo.DocStyle;
import com.xinyou.office.web.doc.vo.DocVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2019/8/29 1:37 PM
 * @history: 1.2019/8/29 created by jianfeng.zheng
 */
@Service
public class AttachmentService {

    @Autowired
    private AttachmentDao attachmentDao;

    @Autowired
    private DocDao docDao;

    /**
     * 查询附件
     *
     * @param docId
     * @return
     */
    public List<AttachmentVO> queryAttachment(Long docId) {
        return attachmentDao.queryAttachment(docId);
    }

    /**
     * 保存附件
     *
     * @param attachments
     * @return
     */
    public Long apply(List<AttachmentVO> attachments) {
        List<AttachmentEO> attachmentEOs = BeanUtil.convertArray(attachments, AttachmentEO.class);
        Long id = attachmentDao.apply(attachmentEOs);
        this.updateDocAttachment(attachments.get(0).getDocId());
        return id;
    }

    /**
     * 删除附件
     *
     * @param rowid
     * @return
     */
    public Integer deleteAttachment(Long rowid) {
        return attachmentDao.deleteAttachment(rowid);
    }

    /**
     * 获取附件详情
     *
     * @param rowid
     * @return
     */
    public AttachmentVO queryAttachmentDetail(Long rowid) {
        return attachmentDao.queryAttachmentDetail(rowid);
    }


    /**
     * 更新附件信息
     *
     * @param docId
     */
    public void updateDocAttachment(Long docId) {
        List<AttachmentVO> attachments = this.queryAttachment(docId);
        if (attachments != null && !attachments.isEmpty()) {
            StringBuffer text = new StringBuffer();
            for (AttachmentVO attachment : attachments) {
                if (text.length() > 0) {
                    text.append("\n");
                }
                text.append(attachment.getFileName());
            }
            DocEO docEO = docDao.queryDocEntity(docId);
            DocStyle style = JSON.parseObject(docEO.getDocStyle(), DocStyle.class);
            style.getAttachment().setText(text.toString());
            docEO.setDocStyle(JSON.toJSONString(style));
            DocVO docVO = new DocVO();
            docVO.setDocStyle(docEO.getDocStyle());
            docVO.setId(docEO.getId());
            docDao.updateStyle(docVO);
        } else {
            return;
        }
    }
}
