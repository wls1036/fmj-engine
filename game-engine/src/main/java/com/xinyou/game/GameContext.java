package com.xinyou.game;

import com.xinyou.game.bbk.RomBlock;
import com.xinyou.game.resource.ResourceIndex;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2021/12/25 11:01 上午
 * @history: 1.2021/12/25 created by jianfeng.zheng
 */
public class GameContext {
    private String gameName;


    private Map<ResourceIndex, Object> gameResources;

    private Map<ResourceIndex, RomBlock> offsetIndex;

    public GameContext() {
        this.gameResources = new HashMap<>();
        this.offsetIndex = new HashMap<>();
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public void addResource(ResourceIndex index, Object resource) {
        this.gameResources.put(index, resource);
    }

    public void addResourceOffset(ResourceIndex index, RomBlock romBlock) {
        this.offsetIndex.put(index, romBlock);
    }

    public void addResource(int fileType, int resourceType, int resourceIndex, Object resource) {
        this.addResource(ResourceIndex.build(fileType, resourceType, resourceIndex), resource);
    }

    public <T> T getResource(int fileType, int resourceType, int resourceIndex, Class<T> type) {
        return this.getResource(ResourceIndex.build(fileType, resourceType, resourceIndex), type);
    }

    public <T> T getResource(ResourceIndex index, Class<T> type) {
        return (T) this.gameResources.get(index);
    }

    public RomBlock getBlock(int fileType, int resourceType, int resourceIndex) {
        return this.offsetIndex.get(ResourceIndex.build(fileType, resourceType, resourceIndex));
    }
}
