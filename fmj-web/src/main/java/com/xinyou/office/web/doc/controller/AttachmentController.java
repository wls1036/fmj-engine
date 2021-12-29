package com.xinyou.office.web.doc.controller;

import com.definesys.mpaas.common.http.Response;
import com.definesys.mpaas.query.db.PageQueryResult;
import com.xinyou.office.web.doc.vo.AttachmentVO;
import com.xinyou.office.web.doc.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2019/8/29 1:33 PM
 * @history: 1.2019/8/29 created by jianfeng.zheng
 */
@RestController
@RequestMapping(value = "attachment")
public class AttachmentController {

    @Autowired
    private AttachmentService attachmentService;

    /**
     * 附件查询
     *
     * @param docId
     * @return
     */
    @GetMapping(value = "query")
    private Response queryAttachment(@RequestParam(value = "docId", required = false) Long docId) {
        List<AttachmentVO> result = attachmentService.queryAttachment(docId);
        return Response.ok().table(result);
    }

    /**
     * 保存附件
     *
     * @param attachments
     * @return
     */
    @PostMapping(value = "apply")
    private Response apply(@RequestBody List<AttachmentVO> attachments) {
        return Response.ok().data(attachmentService.apply(attachments));
    }

    /**
     * 删除附件
     *
     * @param rowid
     * @return
     */
    @GetMapping(value = "delete")
    private Response deleteAttachment(@RequestParam(value = "rowid") Long rowid) {
        return Response.ok().data(attachmentService.deleteAttachment(rowid));
    }

    /**
     * 获取附件详细信息
     *
     * @param rowid
     * @return
     */
    @GetMapping(value = "detail")
    private Response detail(@RequestParam(value = "rowid") Long rowid) {
        return Response.ok().data(attachmentService.queryAttachmentDetail(rowid));
    }
}
