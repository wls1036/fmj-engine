package com.xinyou.office.web.{code}.dao;

import com.definesys.mpaas.query.MpaasQueryFactory;
import com.definesys.mpaas.query.db.PageQueryResult;
import com.xinyou.office.web.{code}.eo.{codeUpper}EO;
import com.xinyou.office.web.{code}.vo.{codeUpper}VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2019/8/29 1:39 PM
 * @history: 1.2019/8/29 created by jianfeng.zheng
 */
@Component
public class {codeUpper}Dao {

    @Autowired
    private MpaasQueryFactory sw;

    /**
     * 查询{name}
     *
     * @param searchText
     * @return
     */
    public PageQueryResult<{codeUpper}VO> query{codeUpper}(String searchText) {
        return sw.buildQuery()
                .doPageQuery({codeUpper}VO.class);
    }

    /**
     * 保存{name}
     *
     * @param {code}
     * @return
     */
    public Long apply({codeUpper}EO {code}) {
        sw.buildQuery()
                .doMerge({code});
        return {code}.getId();
    }

    /**
     * 删除{name}
     *
     * @param rowid
     * @return
     */
    public Integer delete{codeUpper}(Long rowid) {
        return sw.buildQuery()
                .eq("id", rowid)
                .doDelete({codeUpper}EO.class);
    }

    /**
     * 查询{name}详情
     *
     * @param rowid
     * @return
     */
    public {codeUpper}VO query{codeUpper}Detail(Long rowid) {
        return sw.buildQuery()
                .eq("id", rowid)
                .doQueryFirst({codeUpper}VO.class);
    }
}
