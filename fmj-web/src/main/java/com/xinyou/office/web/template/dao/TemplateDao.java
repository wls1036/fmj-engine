package com.xinyou.office.web.template.dao;

import com.definesys.mpaas.query.MpaasQueryFactory;
import com.definesys.mpaas.query.db.PageQueryResult;
import com.xinyou.office.web.template.eo.TemplateEO;
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
public class TemplateDao {

    @Autowired
    private MpaasQueryFactory sw;

    /**
     * 查询模板
     *
     * @param searchText
     * @return
     */
    public PageQueryResult<TemplateVO> queryTemplate(String searchText) {
        return sw.buildQuery()
                .or()
                .like("name", searchText)
                .like("description", searchText)
                .doPageQuery(TemplateVO.class);
    }

    /**
     * 保存模板
     *
     * @param template
     * @return
     */
    public Long apply(TemplateEO template) {
        sw.buildQuery()
                .doMerge(template);
        return template.getId();
    }

    /**
     * 删除模板
     *
     * @param rowid
     * @return
     */
    public Integer deleteTemplate(Long rowid) {
        return sw.buildQuery()
                .eq("id", rowid)
                .doDelete(TemplateEO.class);
    }

    /**
     * 查询模板详情
     *
     * @param rowid
     * @return
     */
    public TemplateVO queryTemplateDetail(Long rowid) {
        return sw.buildQuery()
                .eq("id", rowid)
                .doQueryFirst(TemplateVO.class);
    }

    /**
     * 查询模板VO
     *
     * @return
     */
    public List<TemplateVO> queryTemplateLov() {
        return sw.buildQuery()
                .select("id", "name")
                .doQuery(TemplateVO.class);
    }
}
