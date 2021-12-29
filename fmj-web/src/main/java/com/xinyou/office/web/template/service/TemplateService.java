package com.xinyou.office.web.template.service;

import com.definesys.mpaas.query.db.PageQueryResult;
import com.xinyou.office.web.seal.vo.SealVO;
import com.xinyou.office.web.template.eo.TemplateEO;
import com.xinyou.office.web.template.vo.TemplateVO;
import com.xinyou.office.web.template.dao.TemplateDao;
import com.definesys.mpaas.query.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2019/8/29 1:37 PM
 * @history: 1.2019/8/29 created by jianfeng.zheng
 */
@Service
public class TemplateService {

    @Value("${app.host:}")
    private String host;

    @Autowired
    private TemplateDao templateDao;

    /**
     * 查询模板
     *
     * @param searchText
     * @return
     */
    public PageQueryResult queryTemplate(String searchText) {
        PageQueryResult<TemplateVO> result = templateDao.queryTemplate(searchText);
        return result;
    }

    /**
     * 保存模板
     *
     * @param template
     * @return
     */
    public Long apply(TemplateVO template) {
        TemplateEO templateEO = BeanUtil.convert(template, TemplateEO.class);
        return templateDao.apply(templateEO);
    }

    /**
     * 删除模板
     *
     * @param rowid
     * @return
     */
    public Integer deleteTemplate(Long rowid) {
        return templateDao.deleteTemplate(rowid);
    }

    /**
     * 获取模板详情
     *
     * @param rowid
     * @return
     */
    public TemplateVO queryTemplateDetail(Long rowid) {
        TemplateVO item = templateDao.queryTemplateDetail(rowid);
        return item;
    }

    /**
     * 获取图片下载路径
     *
     * @param docId
     * @return
     */
    private String getFileURL(String docId) {
        return host + "/fnd/file/download?docId=" + docId;
    }

    /**
     * 模板Lov
     *
     * @return
     */
    public List<TemplateVO> queryTemplateLov() {
        return templateDao.queryTemplateLov();
    }
}
