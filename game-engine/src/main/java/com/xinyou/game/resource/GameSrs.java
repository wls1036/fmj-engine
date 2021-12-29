package com.xinyou.game.resource;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2021/12/26 10:36 上午
 * @history: 1.2021/12/26 created by jianfeng.zheng
 */
public class GameSrs {

    /**
     * 帧数量
     */
    private Integer frameCount;

    private Integer startFrame;

    private Integer endFrame;

    private Integer resourceIndex;

    private Integer imageCount;

    private List<GameFrame> frames = new ArrayList<>();

    public Integer getFrameCount() {
        return frameCount;
    }

    public void setFrameCount(Integer frameCount) {
        this.frameCount = frameCount;
    }

    public Integer getStartFrame() {
        return startFrame;
    }

    public void setStartFrame(Integer startFrame) {
        this.startFrame = startFrame;
    }

    public Integer getEndFrame() {
        return endFrame;
    }

    public void setEndFrame(Integer endFrame) {
        this.endFrame = endFrame;
    }

    public Integer getResourceIndex() {
        return resourceIndex;
    }

    public void setResourceIndex(Integer resourceIndex) {
        this.resourceIndex = resourceIndex;
    }

    public Integer getImageCount() {
        return imageCount;
    }

    public void setImageCount(Integer imageCount) {
        this.imageCount = imageCount;
    }

    public List<GameFrame> getFrames() {
        return frames;
    }

    public void setFrames(List<GameFrame> frames) {
        this.frames = frames;
    }

    public void addFrame(GameFrame frame) {
        this.frames.add(frame);
    }
}
