package com.xinyou.office.web.doc.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2021/12/21 9:02 下午
 * @history: 1.2021/12/21 created by jianfeng.zheng
 */

public class DocumentMergeVO {
    private List<String> fileUrlList;
    private List<String> attachmentFileUrlList;
    private String outputFilePath;

    public String getOutputFilePath() {
        return outputFilePath;
    }

    public void setOutputFilePath(String outputFilePath) {
        this.outputFilePath = outputFilePath;
    }

    public void addFile(String url) {
        if (this.fileUrlList == null) {
            this.fileUrlList = new ArrayList<>();
        }
        this.fileUrlList.add(url);
    }

    public void addAttachment(String url) {
        if (this.attachmentFileUrlList == null) {
            this.attachmentFileUrlList = new ArrayList<>();
        }
        this.attachmentFileUrlList.add(url);
    }

    public List<String> getFileUrlList() {
        return fileUrlList;
    }

    public void setFileUrlList(List<String> fileUrlList) {
        this.fileUrlList = fileUrlList;
    }

    public List<String> getAttachmentFileUrlList() {
        return attachmentFileUrlList;
    }

    public void setAttachmentFileUrlList(List<String> attachmentFileUrlList) {
        this.attachmentFileUrlList = attachmentFileUrlList;
    }
}
