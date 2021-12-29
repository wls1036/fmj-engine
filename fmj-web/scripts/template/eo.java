package com.xinyou.office.web.{code}.eo;

import com.definesys.mpaas.query.annotation.*;

import java.util.Date;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2021/4/16 10:31 上午
 * @history: 1.2021/4/16 created by jianfeng.zheng
 */
@Table(value = "OGGX_{code}")
public class {codeUpper}EO {

    @RowID(sequence = "OGGX_{code}_S", type = RowIDType.AUTO)
    private Long id;
    

    @SystemColumn(SystemColumnType.CREATE_BY)
    @Column(value = "created_by")
    @Tag(value = "创建者", length = "50")
    private String createdBy;

    @SystemColumn(SystemColumnType.CREATE_ON)
    @Column(value = "creation_date")
    @Tag(value = "创建日期")
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
