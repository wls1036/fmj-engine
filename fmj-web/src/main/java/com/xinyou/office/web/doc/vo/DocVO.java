package com.xinyou.office.web.doc.vo;

import com.definesys.fnd.file.eo.FndFileEO;
import com.definesys.mpaas.query.annotation.*;
import com.xinyou.office.web.doc.eo.AttachmentEO;
import com.xinyou.office.web.doc.eo.DocEO;
import com.xinyou.office.web.template.eo.TemplateEO;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2021/4/16 10:31 上午
 * @history: 1.2021/4/16 created by jianfeng.zheng
 */
@VO(eo = DocEO.class)
public class DocVO {

    @RowID(sequence = "OFD_DOC_S", type = RowIDType.AUTO)
    private Long id;

    @Tag(value = "模板ID")
    private Long templateId;

    @Tag(value = "标题", length = "200")
    private String title;

    @Tag(value = "主送机关", length = "200")
    private String toOrg;

    @Tag(value = "抄送机关", length = "500")
    private String ccOrg;

    @Tag(value = "发文机关", length = "200")
    private String draftOrg;

    @Tag(value = "印发机关", length = "200")
    private String printOrg;

    @Tag(value = "发文字号", length = "50")
    private String docNo;

    @Tag(value = "信息公开属性", length = "50")
    private String openAttr;

    @Tag(value = "正文文档ID")
    private Long docFileId;

    @Tag(value = "不予公开原因", length = "50")
    private String unopenReason;

    @Tag(value = "紧急程度", length = "50")
    private String urgentLevel;

    @Tag(value = "密级", length = "50")
    private String secretLevel;

    @Tag(value = "定密依据", length = "500")
    private String secretReason;

    @Tag(value = "文件名称")
    @DataFrom(eo = FndFileEO.class, column = "file_name", where = "id=#docFileId")
    private String docFileName;

    @Tag(value = "文件名称")
    @DataFrom(eo = TemplateEO.class, column = "name", where = "id=#templateId")
    private String templateName;

    @Tag(value = "正文", type = "text")
    private String contentText;

    @Tag(value = "正文html", type = "text")
    private String contentHtml;

    @Tag(value = "全文html", type = "text")
    private String fullHtml;

    @Tag(value = "公文样式文件", type = "text")
    private String docStyle;

    @DataFrom(eo = AttachmentEO.class, where = "doc_id=#id")
    private List<AttachmentVO> attachments;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getToOrg() {
        return toOrg;
    }

    public void setToOrg(String toOrg) {
        this.toOrg = toOrg;
    }

    public String getCcOrg() {
        return ccOrg;
    }

    public void setCcOrg(String ccOrg) {
        this.ccOrg = ccOrg;
    }

    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public String getOpenAttr() {
        return openAttr;
    }

    public void setOpenAttr(String openAttr) {
        this.openAttr = openAttr;
    }

    public Long getDocFileId() {
        return docFileId;
    }

    public void setDocFileId(Long docFileId) {
        this.docFileId = docFileId;
    }

    public String getUnopenReason() {
        return unopenReason;
    }

    public void setUnopenReason(String unopenReason) {
        this.unopenReason = unopenReason;
    }

    public String getUrgentLevel() {
        return urgentLevel;
    }

    public void setUrgentLevel(String urgentLevel) {
        this.urgentLevel = urgentLevel;
    }

    public String getSecretLevel() {
        return secretLevel;
    }

    public void setSecretLevel(String secretLevel) {
        this.secretLevel = secretLevel;
    }

    public String getSecretReason() {
        return secretReason;
    }

    public void setSecretReason(String secretReason) {
        this.secretReason = secretReason;
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

    public String getDocFileName() {
        return docFileName;
    }

    public void setDocFileName(String docFileName) {
        this.docFileName = docFileName;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }

    public String getContentHtml() {
        return contentHtml;
    }

    public void setContentHtml(String contentHtml) {
        this.contentHtml = contentHtml;
    }

    public String getDraftOrg() {
        return draftOrg;
    }

    public void setDraftOrg(String draftOrg) {
        this.draftOrg = draftOrg;
    }

    public String getPrintOrg() {
        return printOrg;
    }

    public void setPrintOrg(String printOrg) {
        this.printOrg = printOrg;
    }

    public String getDocStyle() {
        return docStyle;
    }

    public void setDocStyle(String docStyle) {
        this.docStyle = docStyle;
    }

    public List<AttachmentVO> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<AttachmentVO> attachments) {
        this.attachments = attachments;
    }

    public String getFullHtml() {
        return fullHtml;
    }

    public void setFullHtml(String fullHtml) {
        this.fullHtml = fullHtml;
    }
}
