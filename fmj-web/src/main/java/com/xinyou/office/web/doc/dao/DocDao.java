package com.xinyou.office.web.doc.dao;

import com.definesys.mpaas.query.MpaasQuery;
import com.definesys.mpaas.query.MpaasQueryFactory;
import com.definesys.mpaas.query.db.PageQueryResult;
import com.xinyou.office.web.doc.eo.DocEO;
import com.xinyou.office.web.doc.vo.DocQueryVO;
import com.xinyou.office.web.doc.vo.DocVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2019/8/29 1:39 PM
 * @history: 1.2019/8/29 created by jianfeng.zheng
 */
@Component
public class DocDao {

    @Autowired
    private MpaasQueryFactory sw;

    /**
     * 查询公文
     *
     * @param searchText
     * @return
     */
    public PageQueryResult<DocQueryVO> queryDoc(String searchText) {
        return sw.buildQuery()
                .doPageQuery(DocQueryVO.class);
    }

    /**
     * 保存公文
     *
     * @param doc
     * @return
     */
    public Long apply(DocEO doc) {
        sw.buildQuery()
                .doMerge(doc);
        return doc.getId();
    }

    /**
     * 删除公文
     *
     * @param rowid
     * @return
     */
    public Integer deleteDoc(Long rowid) {
        return sw.buildQuery()
                .eq("id", rowid)
                .doDelete(DocEO.class);
    }

    /**
     * 查询公文详情
     *
     * @param rowid
     * @return
     */
    public DocVO queryDocDetail(Long rowid) {
        return sw.buildQuery()
                .eq("id", rowid)
                .doQueryFirst(DocVO.class);
    }

    /**
     * 查询公文详情
     *
     * @param docId
     * @return
     */
        public DocEO queryDocEntity(Long docId) {
        return sw.buildQuery()
                .eq("id", docId)
                .doQueryFirst(DocEO.class);
    }

    /**
     * 更新样式
     *
     * @param doc
     */
    public void updateStyle(DocVO doc) {
        sw.buildQuery()
                .updateIgnoreNull()
                .update("fullHtml", doc.getFullHtml())
                .update("docStyle", doc.getDocStyle())
                .eq("id", doc.getId())
                .doUpdate(DocVO.class);
    }
}
