package com.xinyou.game.bbk;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2021/12/25 2:11 下午
 * @history: 1.2021/12/25 created by jianfeng.zheng
 */
public class BlockContainer {

    /**
     * 资源块
     */
    private List<RomBlock> blocks = new ArrayList<>();


    /**
     * 添加Block
     *
     * @param block
     */
    public void addBlock(RomBlock block) {
        blocks.add(block);
    }

    /**
     * 获取指定文件类型块
     *
     * @param fileType
     * @param resourceType
     * @return
     */
    public List<RomBlock> getBlocks(Integer fileType, Integer resourceType) {
        List<RomBlock> items = new ArrayList<>();
        for (RomBlock block : blocks) {
            if (block.getFileType() == fileType) {
                if (resourceType != null && block.getResourceType() == resourceType) {
                    items.add(block);
                }
                if (resourceType == null) {
                    items.add(block);
                }
            }
        }
        return items;
    }

    /**
     * 获取指定文件类型块
     *
     * @param fileType
     * @return
     */
    public List<RomBlock> getBlocks(Integer fileType) {
        return this.getBlocks(fileType, null);
    }

    /**
     * 获取图片块
     *
     * @return
     */
    public List<RomBlock> getImageBlocks() {
        List<RomBlock> items = new ArrayList<>();
        items.addAll(this.getBlocks(Constant.RESOURCE_TIL));
        items.addAll(this.getBlocks(Constant.RESOURCE_ACP));
        items.addAll(this.getBlocks(Constant.RESOURCE_GDP));
        items.addAll(this.getBlocks(Constant.RESOURCE_GGJ));
        items.addAll(this.getBlocks(Constant.RESOURCE_PIC));
        return items;
    }
}
