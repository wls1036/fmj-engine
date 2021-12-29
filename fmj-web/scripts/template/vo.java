package com.xinyou.office.web.{code}.vo;

import com.definesys.mpaas.query.annotation.*;
import com.xinyou.office.web.{code}.eo.{codeUpper}EO;

import java.util.Date;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2021/4/16 10:31 上午
 * @history: 1.2021/4/16 created by jianfeng.zheng
 */
@VO(eo = {codeUpper}EO.class)
public class {codeUpper}VO {

    private Long id;

    private String createdBy;

    private Date creationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
