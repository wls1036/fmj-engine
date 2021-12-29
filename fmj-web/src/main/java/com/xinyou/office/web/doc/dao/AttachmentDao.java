package com.xinyou.office.web.doc.dao;

import com.definesys.mpaas.query.MpaasQueryFactory;
import com.definesys.mpaas.query.db.PageQueryResult;
import com.xinyou.office.web.doc.eo.AttachmentEO;
import com.xinyou.office.web.doc.vo.AttachmentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2019/8/29 1:39 PM
 * @history: 1.2019/8/29 created by jianfeng.zheng
 */
@Component
public class AttachmentDao {

    @Autowired
    private MpaasQueryFactory sw;

    /**
     * 查询附件
     *
     * @param docId
     * @return
     */
    public List<AttachmentVO> queryAttachment(Long docId) {
        return sw.buildQuery()
                .notNull(docId)
                .eq("docId", docId)
                .doQuery(AttachmentVO.class);
    }

    /**
     * 保存附件
     *
     * @param attachments
     * @return
     */
    public Long apply(List<AttachmentEO> attachments) {
        sw.buildQuery()
                .doBatchInsert(attachments);
        return null;
    }

    /**
     * 删除附件
     *
     * @param rowid
     * @return
     */
    public Integer deleteAttachment(Long rowid) {
        return sw.buildQuery()
                .eq("id", rowid)
                .doDelete(AttachmentEO.class);
    }

    /**
     * 查询附件详情
     *
     * @param rowid
     * @return
     */
    public AttachmentVO queryAttachmentDetail(Long rowid) {
        return sw.buildQuery()
                .eq("id", rowid)
                .doQueryFirst(AttachmentVO.class);
    }
}
