package com.xinyou.office.web.seal.eo;

import com.definesys.mpaas.query.annotation.*;

import java.util.Date;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2021/4/16 10:31 上午
 * @history: 1.2021/4/16 created by jianfeng.zheng
 */
@Table(value = "ofd_seal")
public class SealEO {

    @RowID(sequence = "OFD_SEAL_S", type = RowIDType.AUTO)
    private Long id;

    @Tag(value = "公章名称", length = "100")
    private String name;

    @Tag(value = "公章描述", length = "200")
    private String description;

    @Tag(value = "公章图片UUID", length = "64")
    private String imageId;

    @Tag(value = "图片高度")
    private Integer height;

    @Tag(value = "图片宽度")
    private Integer width;

    @SystemColumn(SystemColumnType.CREATE_BY)
    @Column(value = "created_by")
    @Tag(value = "创建者", length = "50")
    private String createdBy;

    @SystemColumn(SystemColumnType.CREATE_ON)
    @Column(value = "creation_date")
    @Tag(value = "创建日期")
    private Date creationDate;

    @SystemColumn(SystemColumnType.LASTUPDATE_BY)
    @Column(value = "lastupdate_by")
    @Tag(value = "最后更新者", length = "50")
    private String lastUpdateBy;

    @SystemColumn(SystemColumnType.LASTUPDATE_ON)
    @Column(value = "lastupdate_date")
    @Tag(value = "最后更新日期")
    private Date lastUpdateDate;

    @SystemColumn(SystemColumnType.OBJECT_VERSION)
    @Column(value = "object_version")
    @Tag(value = "版本号")
    private Integer objectVersion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
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

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getObjectVersion() {
        return objectVersion;
    }

    public void setObjectVersion(Integer objectVersion) {
        this.objectVersion = objectVersion;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }
}
