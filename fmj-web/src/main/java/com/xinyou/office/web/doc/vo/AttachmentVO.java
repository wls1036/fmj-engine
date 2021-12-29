package com.xinyou.office.web.doc.vo;

import com.definesys.fnd.file.eo.FndFileEO;
import com.definesys.mpaas.query.annotation.*;
import com.xinyou.office.web.doc.eo.AttachmentEO;

import java.util.Date;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2021/4/16 10:31 上午
 * @history: 1.2021/4/16 created by jianfeng.zheng
 */
@VO(eo = AttachmentEO.class)
public class AttachmentVO {

    @RowID(sequence = "OFD_ATTACHMENT_S", type = RowIDType.AUTO)
    private Long id;

    @Tag(value = "文档编号")
    private Long docId;

    @Tag(value = "文件编号")
    private Long fileId;

    @Tag(value = "文件名称")
    @DataFrom(eo = FndFileEO.class,column = "file_name",where = "id=#fileId")
    private String fileName;

    @Tag(value = "文件名称")
    @DataFrom(eo = FndFileEO.class,column = "uuid",where = "id=#fileId")
    private String uuid;

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

    public Long getDocId() {
        return docId;
    }

    public void setDocId(Long docId) {
        this.docId = docId;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
