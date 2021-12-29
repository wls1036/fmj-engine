package com.xinyou.office.web.doc.vo;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2021/12/17 4:19 下午
 * @history: 1.2021/12/17 created by jianfeng.zheng
 */
public class DocStyle {

    //发文机关
    private Element draftOrg;

    //签发人
    private Element draftPeople;

    //发文字号
    private Element docCode;

    //标题
    private Element title;

    //主送机关
    private Element toOrg;

    //抄送机关
    private Element ccOrg;

    //紧急程度
    private String urgentLevel;

    //密级
    private String secretLevel;

    //分隔线
    private String divider;

    //正文
    private Element content;

    //附件
    private Element attachment;

    //印发机关
    private Element printOrg;

    //署名
    private Element sign;

    //页码
    private Element page;

    //公章
    private Element seal;


    public Element getDraftOrg() {
        return draftOrg;
    }

    public void setDraftOrg(Element draftOrg) {
        this.draftOrg = draftOrg;
    }

    public Element getDraftPeople() {
        return draftPeople;
    }

    public void setDraftPeople(Element draftPeople) {
        this.draftPeople = draftPeople;
    }

    public Element getDocCode() {
        return docCode;
    }

    public void setDocCode(Element docCode) {
        this.docCode = docCode;
    }

    public Element getTitle() {
        return title;
    }

    public void setTitle(Element title) {
        this.title = title;
    }

    public Element getToOrg() {
        return toOrg;
    }

    public void setToOrg(Element toOrg) {
        this.toOrg = toOrg;
    }

    public Element getCcOrg() {
        return ccOrg;
    }

    public void setCcOrg(Element ccOrg) {
        this.ccOrg = ccOrg;
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

    public String getDivider() {
        return divider;
    }

    public void setDivider(String divider) {
        this.divider = divider;
    }

    public Element getContent() {
        return content;
    }

    public void setContent(Element content) {
        this.content = content;
    }

    public Element getAttachment() {
        return attachment;
    }

    public void setAttachment(Element attachment) {
        this.attachment = attachment;
    }

    public Element getPrintOrg() {
        return printOrg;
    }

    public void setPrintOrg(Element printOrg) {
        this.printOrg = printOrg;
    }

    public Element getSign() {
        return sign;
    }

    public void setSign(Element sign) {
        this.sign = sign;
    }

    public Element getPage() {
        return page;
    }

    public void setPage(Element page) {
        this.page = page;
    }

    public Element getSeal() {
        return seal;
    }

    public void setSeal(Element seal) {
        this.seal = seal;
    }

    public void clearDisableText() {
        this.clearElementText(this.draftOrg);
        this.clearElementText(this.draftPeople);
        this.clearElementText(this.docCode);
        this.clearElementText(this.title);
        this.clearElementText(this.toOrg);
        this.clearElementText(this.content);
        this.clearElementText(this.attachment);
        this.clearElementText(this.printOrg);
        this.clearElementText(this.sign);
        this.clearElementText(this.page);
    }

    public void clearElementText(Element element) {
        if (element != null && !element.enable()) {
            element.setText(null);
            element.setDate(null);
            element.setOrg(null);
        }
    }


}
