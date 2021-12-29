package com.xinyou.office.web.seal.controller;

import com.definesys.mpaas.common.http.Response;
import com.definesys.mpaas.query.db.PageQueryResult;
import com.xinyou.office.web.seal.eo.SealEO;
import com.xinyou.office.web.seal.vo.SealVO;
import com.xinyou.office.web.seal.service.SealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.Map;


/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2019/8/29 1:33 PM
 * @history: 1.2019/8/29 created by jianfeng.zheng
 */
@RestController
@RequestMapping(value = "seal")
public class SealController {

    @Autowired
    private SealService sealService;

    /**
     * 公章查询
     *
     * @param searchText
     * @return
     */
    @GetMapping(value = "query")
    private Response querySeal(@RequestParam(value = "searchContent", required = false) String searchText) {
        PageQueryResult result = sealService.querySeal(searchText);
        return Response.ok().setTotal(result.getCount()).table(result.getResult());
    }

    /**
     * 模板查询
     *
     * @return
     */
    @GetMapping(value = "lov")
    private Response querySealLov() {
        return Response.ok().table(sealService.querySealLov());
    }

    /**
     * 保存公章
     *
     * @param seal
     * @return
     */
    @PostMapping(value = "apply")
    private Response apply(@RequestBody SealVO seal) {
        return Response.ok().data(sealService.apply(seal));
    }

    /**
     * 删除公章
     *
     * @param rowid
     * @return
     */
    @GetMapping(value = "delete")
    private Response deleteSeal(@RequestParam(value = "rowid") Long rowid) {
        return Response.ok().data(sealService.deleteSeal(rowid));
    }

    /**
     * 获取公章详细信息
     *
     * @param rowid
     * @return
     */
    @GetMapping(value = "detail")
    private Response detail(@RequestParam(value = "rowid") Long rowid) {
        return Response.ok().data(sealService.querySealDetail(rowid));
    }
}
