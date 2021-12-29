package com.xinyou.office.web.{code}.controller;

import com.definesys.mpaas.common.http.Response;
import com.definesys.mpaas.query.db.PageQueryResult;
import com.xinyou.office.web.{code}.eo.{codeUpper}EO;
import com.xinyou.office.web.{code}.vo.{codeUpper}VO;
import com.xinyou.office.web.{code}.service.{codeUpper}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;


/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2019/8/29 1:33 PM
 * @history: 1.2019/8/29 created by jianfeng.zheng
 */
@RestController
@RequestMapping(value = "{code}")
public class {codeUpper}Controller {

    @Autowired
    private {codeUpper}Service {code}Service;

    /**
     * {name}查询
     *
     * @param searchText
     * @return
     */
    @GetMapping(value = "query")
    private Response query{codeUpper}(@RequestParam(value = "searchContent", required = false) String searchText) {
        PageQueryResult result = {code}Service.query{codeUpper}(searchText);
        return Response.ok().setTotal(result.getCount()).table(result.getResult());
    }

    /**
     * 保存{name}
     *
     * @param {code}
     * @return
     */
    @PostMapping(value = "apply")
    private Response apply(@RequestBody {codeUpper}VO {code}) {
        return Response.ok().data({code}Service.apply({code}));
    }

    /**
     * 删除{name}
     *
     * @param rowid
     * @return
     */
    @GetMapping(value = "delete")
    private Response delete{codeUpper}(@RequestParam(value = "rowid") Long rowid) {
        return Response.ok().data({code}Service.delete{codeUpper}(rowid));
    }

    /**
     * 获取{name}详细信息
     *
     * @param rowid
     * @return
     */
    @GetMapping(value = "detail")
    private Response detail(@RequestParam(value = "rowid") Long rowid) {
        return Response.ok().data({code}Service.query{codeUpper}Detail(rowid));
    }
}
