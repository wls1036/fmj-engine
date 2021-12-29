package com.xinyou.office.web.template.vo;

import com.definesys.fnd.file.eo.FndFileEO;
import com.definesys.mpaas.query.annotation.*;
import com.xinyou.office.web.template.eo.TemplateEO;

import java.util.Date;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2021/4/16 10:31 上午
 * @history: 1.2021/4/16 created by jianfeng.zheng
 */
@VO(eo = TemplateEO.class)
public class TemplateVO {

    @RowID(sequence = "OFD_TEMPLATE_S", type = RowIDType.AUTO)
    private Long id;

    @Tag(value = "模板名称", length = "100")
    private String name;

    @Tag(value = "模板描述", length = "200")
    private String description;

    @Tag(value = "标题", length = "200")
    private String title;

    @Tag(value = "发文机关署名", length = "200")
    private String draftOrgSign;

    @Tag(value = "发文机关标志", length = "200")
    private String draftOrgTitle;

    @Tag(value = "印发机关", length = "200")
    private String printOrg;

    @Tag(value = "公文样式文件", type = "text")
    private String style;

    @Tag(value = "公章编号")
    private Long sealId;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDraftOrgSign() {
        return draftOrgSign;
    }

    public void setDraftOrgSign(String draftOrgSign) {
        this.draftOrgSign = draftOrgSign;
    }

    public String getDraftOrgTitle() {
        return draftOrgTitle;
    }

    public void setDraftOrgTitle(String draftOrgTitle) {
        this.draftOrgTitle = draftOrgTitle;
    }

    public String getPrintOrg() {
        return printOrg;
    }

    public void setPrintOrg(String printOrg) {
        this.printOrg = printOrg;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
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

    public Long getSealId() {
        return sealId;
    }

    public void setSealId(Long sealId) {
        this.sealId = sealId;
    }
}
