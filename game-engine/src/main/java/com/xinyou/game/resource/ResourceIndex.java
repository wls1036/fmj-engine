package com.xinyou.game.resource;


/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2021/12/25 9:05 下午
 * @history: 1.2021/12/25 created by jianfeng.zheng
 */
public class ResourceIndex {
    private int fileType;
    private int resourceType;
    private int resourceIndex;

    public static ResourceIndex build(int fileType, int resourceType, int resourceIndex) {
        ResourceIndex index = new ResourceIndex();
        index.setFileType(fileType);
        index.setResourceType(resourceType);
        index.setResourceIndex(resourceIndex);
        return index;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResourceIndex)) return false;
        ResourceIndex that = (ResourceIndex) o;
        return fileType == that.fileType &&
                resourceType == that.resourceType &&
                resourceIndex == that.resourceIndex;
    }

    @Override
    public int hashCode() {
        return fileType << 16 | resourceType << 8 | (resourceIndex & 0xFF);
    }
}
