package com.xinyou.office.web.{code}.service;

import com.definesys.mpaas.query.db.PageQueryResult;
import com.xinyou.office.web.{code}.eo.{codeUpper}EO;
import com.xinyou.office.web.{code}.vo.{codeUpper}VO;
import com.xinyou.office.web.{code}.dao.{codeUpper}Dao;
import com.definesys.mpaas.query.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2019/8/29 1:37 PM
 * @history: 1.2019/8/29 created by jianfeng.zheng
 */
@Service
public class {codeUpper}Service {

    @Autowired
    private {codeUpper}Dao {code}Dao;

    /**
     * 查询{name}
     *
     * @param searchText
     * @return
     */
    public PageQueryResult query{codeUpper}(String searchText) {
        return {code}Dao.query{codeUpper}(searchText);
    }

    /**
     * 保存{name}
     *
     * @param {code}
     * @return
     */
    public Long apply({codeUpper}VO {code}) {
        {codeUpper}EO {code}EO= BeanUtil.convert({code},{codeUpper}EO.class);
        return {code}Dao.apply({code}EO);
    }

    /**
     * 删除{name}
     *
     * @param rowid
     * @return
     */
    public Integer delete{codeUpper}(Long rowid) {
        return {code}Dao.delete{codeUpper}(rowid);
    }

    /**
     * 获取{name}详情
     *
     * @param rowid
     * @return
     */
    public {codeUpper}VO query{codeUpper}Detail(Long rowid) {
        return {code}Dao.query{codeUpper}Detail(rowid);
    }
}
