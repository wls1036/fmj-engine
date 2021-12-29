package com.xinyou.office.web.doc.controller;

import com.definesys.fnd.file.service.FndFileService;
import com.definesys.fnd.file.vo.FndFileVO;
import com.definesys.mpaas.common.http.Response;
import com.definesys.mpaas.query.db.PageQueryResult;
import com.xinyou.office.web.doc.vo.DocVO;
import com.xinyou.office.web.doc.service.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2019/8/29 1:33 PM
 * @history: 1.2019/8/29 created by jianfeng.zheng
 */
@RestController
@RequestMapping(value = "doc")
public class DocController {

    @Autowired
    private DocService docService;

    @Autowired
    private FndFileService fileService;

    /**
     * 公文查询
     *
     * @param searchText
     * @return
     */
    @GetMapping(value = "query")
    private Response queryDoc(@RequestParam(value = "searchContent", required = false) String searchText) {
        PageQueryResult result = docService.queryDoc(searchText);
        return Response.ok().setTotal(result.getCount()).table(result.getResult());
    }

    /**
     * 保存公文
     *
     * @param doc
     * @return
     */
    @PostMapping(value = "apply")
    private Response apply(@RequestBody DocVO doc) {
        return Response.ok().data(docService.apply(doc));
    }

    /**
     * 删除公文
     *
     * @param rowid
     * @return
     */
    @GetMapping(value = "delete")
    private Response deleteDoc(@RequestParam(value = "rowid") Long rowid) {
        return Response.ok().data(docService.deleteDoc(rowid));
    }

    /**
     * 获取公文详细信息
     *
     * @param rowid
     * @return
     */
    @GetMapping(value = "detail")
    private Response detail(@RequestParam(value = "rowid") Long rowid) {
        return Response.ok().data(docService.queryDocDetail(rowid));
    }


    /**
     * 多文件上传
     *
     * @param files
     * @param target
     * @param targetId
     * @param tag
     * @return
     */
    @PostMapping("upload")
    private Response upload(@RequestParam("files") MultipartFile[] files,
                            @RequestParam(value = "target", required = false) String target,
                            @RequestParam(value = "targetId", required = false) String targetId,
                            @RequestParam(value = "tag", required = false) String tag) {
        if (files == null || files.length == 0) {
            return Response.ok();
        }
        List<FndFileVO> docFiles = fileService.uploadFile(files, target, targetId, tag);
        docFiles.get(0).setTag(docService.extractDocumentContent(docFiles.get(0)));
        return Response.ok().table(docFiles);
    }


    /**
     * 保存公文
     *
     * @param doc
     * @return
     */
    @PostMapping(value = "updateStyle")
    private Response updateStyle(@RequestBody DocVO doc) {
        docService.updateStyle(doc);
        return Response.ok();
    }

    /**
     * 返回可打印html
     *
     * @param docId
     * @return
     */
    @GetMapping(value = "printHtml")
    @ResponseBody
    private String getPrintHtml(@RequestParam(value = "docId") Long docId) {
        return docService.getPrintHtml(docId);
    }

    /**
     * 下载PDF
     *
     * @param docId
     * @return
     */
    @GetMapping(value = "download")
    private Response download(@RequestParam(value = "docId") Long docId) {
        return Response.ok().data(docService.download(docId));
    }

    /**
     * 下载PDF
     *
     * @param docId
     * @return
     */
    @GetMapping(value = "downloadPDF")
    private ResponseEntity<Resource> downloadPDF(@RequestParam("docId") Long docId) {
        return docService.downloadPDF(docId);
    }

}
