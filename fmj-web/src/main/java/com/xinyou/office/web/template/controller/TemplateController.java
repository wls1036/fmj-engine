package com.xinyou.office.web.template.controller;

import com.definesys.mpaas.common.http.Response;
import com.definesys.mpaas.query.db.PageQueryResult;
import com.xinyou.office.web.template.eo.TemplateEO;
import com.xinyou.office.web.template.vo.TemplateVO;
import com.xinyou.office.web.template.service.TemplateService;
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
@RequestMapping(value = "template")
public class TemplateController {

    @Autowired
    private TemplateService templateService;

    /**
     * 模板查询
     *
     * @param searchText
     * @return
     */
    @GetMapping(value = "query")
    private Response queryTemplate(@RequestParam(value = "searchContent", required = false) String searchText) {
        PageQueryResult result = templateService.queryTemplate(searchText);
        return Response.ok().setTotal(result.getCount()).table(result.getResult());
    }

    /**
     * 模板查询
     *
     * @return
     */
    @GetMapping(value = "lov")
    private Response queryTemplateLov() {
        return Response.ok().table(templateService.queryTemplateLov());
    }

    /**
     * 保存模板
     *
     * @param template
     * @return
     */
    @PostMapping(value = "apply")
    private Response apply(@RequestBody TemplateVO template) {
        return Response.ok().data(templateService.apply(template));
    }

    /**
     * 删除模板
     *
     * @param rowid
     * @return
     */
    @GetMapping(value = "delete")
    private Response deleteTemplate(@RequestParam(value = "rowid") Long rowid) {
        return Response.ok().data(templateService.deleteTemplate(rowid));
    }

    /**
     * 获取模板详细信息
     *
     * @param rowid
     * @return
     */
    @GetMapping(value = "detail")
    private Response detail(@RequestParam(value = "rowid") Long rowid) {
        return Response.ok().data(templateService.queryTemplateDetail(rowid));
    }
}
