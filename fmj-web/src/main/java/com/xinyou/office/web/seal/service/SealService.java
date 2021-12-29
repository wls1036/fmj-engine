package com.xinyou.office.web.seal.service;

import com.definesys.mpaas.query.db.PageQueryResult;
import com.xinyou.office.web.seal.eo.SealEO;
import com.xinyou.office.web.seal.vo.SealVO;
import com.xinyou.office.web.seal.dao.SealDao;
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
public class SealService {

    @Value("${app.host:}")
    private String host;

    @Autowired
    private SealDao sealDao;

    /**
     * 查询公章
     *
     * @param searchText
     * @return
     */
    public PageQueryResult querySeal(String searchText) {
        PageQueryResult<SealVO> result = sealDao.querySeal(searchText);
        for (SealVO item : result.getResult()) {
            item.setImageUrl(this.getImageURL(item.getImageId()));
        }
        return result;
    }

    /**
     * 保存公章
     *
     * @param seal
     * @return
     */
    public Long apply(SealVO seal) {
        SealEO sealEO = BeanUtil.convert(seal, SealEO.class);
        return sealDao.apply(sealEO);
    }

    /**
     * 删除公章
     *
     * @param rowid
     * @return
     */
    public Integer deleteSeal(Long rowid) {
        return sealDao.deleteSeal(rowid);
    }

    /**
     * 获取公章详情
     *
     * @param rowid
     * @return
     */
    public SealVO querySealDetail(Long rowid) {
        SealVO item = sealDao.querySealDetail(rowid);
        if (item != null) {
            item.setImageUrl(this.getImageURL(item.getImageId()));
        }
        return item;
    }

    /**
     * 获取图片下载路径
     *
     * @param docId
     * @return
     */
    private String getImageURL(String docId) {
        return host + "/fnd/file/download?docId=" + docId;
    }

    /**
     * 查询公章LOV
     * @return
     */
    public List<SealVO> querySealLov() {
        return sealDao.querySealLov();
    }
}
