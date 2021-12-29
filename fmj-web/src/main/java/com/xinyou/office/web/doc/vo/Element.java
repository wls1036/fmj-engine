package com.xinyou.office.web.doc.vo;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2021/12/17 4:20 下午
 * @history: 1.2021/12/17 created by jianfeng.zheng
 */
public class Element {

    //元素类型
    private String type;

    //文本
    private String text;

    //字体
    private String font;

    //字体大小(ex:16pt)
    private String fontSize;

    //对齐方式(针对发文机关标志)
    private String align;

    //缩放比例(针对发文机关标志)
    private String scale;

    //是否启用
    private Boolean enable;

    //是否加粗
    private Boolean bold;

    //附件是否标志顺序
    private Boolean sequence;

    //日期字段
    private String date;

    //发文机关署名(用于署名)
    private String org;

    //是否隐藏第一页页码(针对页码)
    private Boolean hideFirstPage;

    //公章高度
    private Integer height;

    //公章宽度
    private Integer width;

    //公章图片路径
    private String url;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public String getFontSize() {
        return fontSize;
    }

    public void setFontSize(String fontSize) {
        this.fontSize = fontSize;
    }

    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Boolean getBold() {
        return bold;
    }

    public void setBold(Boolean bold) {
        this.bold = bold;
    }

    public Boolean getSequence() {
        return sequence;
    }

    public void setSequence(Boolean sequence) {
        this.sequence = sequence;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getHideFirstPage() {
        return hideFirstPage;
    }

    public void setHideFirstPage(Boolean hideFirstPage) {
        this.hideFirstPage = hideFirstPage;
    }

    public Boolean enable() {
        return this.enable == null ? true : this.enable;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
