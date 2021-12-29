package com.xinyou.game.bbk;

import com.xinyou.game.resource.ResourceIndex;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2021/12/25 10:36 上午
 * @history: 1.2021/12/25 created by jianfeng.zheng
 */
public class RomBlock {

    /**
     * 文件类型
     */
    private int fileType;

    /**
     * 资源类型
     */
    private int resourceType;

    /**
     * 资源索引
     */
    private int resourceIndex;

    /**
     * 块索引
     */
    private int blockIndex;

    /**
     * 块索引-低位
     */
    private int offsetLow;

    /**
     * 块索引-高位
     */
    private int offsetHigh;

    /**
     * 块偏移
     */
    private int offset;


    public int getFileType() {
        return fileType;
    }

    public void setFileType(int fileType) {
        this.fileType = fileType;
    }

    public int getResourceType() {
        return resourceType;
    }

    public void setResourceType(int resourceType) {
        this.resourceType = resourceType;
    }

    public int getResourceIndex() {
        return resourceIndex;
    }

    public void setResourceIndex(int resourceIndex) {
        this.resourceIndex = resourceIndex;
    }

    public int getBlockIndex() {
        return blockIndex;
    }

    public void setBlockIndex(int blockIndex) {
        this.blockIndex = blockIndex;
    }

    public int getOffsetLow() {
        return offsetLow;
    }

    public void setOffsetLow(int offsetLow) {
        this.offsetLow = offsetLow;
    }

    public int getOffsetHigh() {
        return offsetHigh;
    }

    public void setOffsetHigh(int offsetHigh) {
        this.offsetHigh = offsetHigh;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public ResourceIndex buildResourceIndex() {
        return ResourceIndex.build(this.fileType, this.resourceType, this.resourceIndex);
    }
}
