package com.xinyou.office.web.seal.dao;

import com.definesys.mpaas.query.MpaasQueryFactory;
import com.definesys.mpaas.query.db.PageQueryResult;
import com.xinyou.office.web.seal.eo.SealEO;
import com.xinyou.office.web.seal.vo.SealVO;
import com.xinyou.office.web.template.vo.TemplateVO;
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
public class SealDao {

    @Autowired
    private MpaasQueryFactory sw;

    /**
     * 查询公章
     *
     * @param searchText
     * @return
     */
    public PageQueryResult<SealVO> querySeal(String searchText) {
        return sw.buildQuery()
                .or()
                .like("name", searchText)
                .like("description", searchText)
                .doPageQuery(SealVO.class);
    }

    /**
     * 保存公章
     *
     * @param seal
     * @return
     */
    public Long apply(SealEO seal) {
        sw.buildQuery()
                .doMerge(seal);
        return seal.getId();
    }

    /**
     * 删除公章
     *
     * @param rowid
     * @return
     */
    public Integer deleteSeal(Long rowid) {
        return sw.buildQuery()
                .eq("id", rowid)
                .doDelete(SealEO.class);
    }

    /**
     * 查询公章详情
     *
     * @param rowid
     * @return
     */
    public SealVO querySealDetail(Long rowid) {
        return sw.buildQuery()
                .eq("id", rowid)
                .doQueryFirst(SealVO.class);
    }

    /**
     * 查询公章LOV
     *
     * @return
     */
    public List<SealVO> querySealLov() {
        return sw.buildQuery()
                .doQuery(SealVO.class);
    }
}
