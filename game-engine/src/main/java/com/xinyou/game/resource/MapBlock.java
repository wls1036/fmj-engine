package com.xinyou.game.resource;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2021/12/25 3:59 下午
 * @history: 1.2021/12/25 created by jianfeng.zheng
 */
public class MapBlock {
    private Boolean canWalk;

    private Integer eventIndex;

    private Integer tileIndex;

    private Integer imageIndex;

    public Boolean getCanWalk() {
        return canWalk;
    }

    public void setCanWalk(Boolean canWalk) {
        this.canWalk = canWalk;
    }

    public Integer getEventIndex() {
        return eventIndex;
    }

    public void setEventIndex(Integer eventIndex) {
        this.eventIndex = eventIndex;
    }

    public Integer getTileIndex() {
        return tileIndex;
    }

    public void setTileIndex(Integer tileIndex) {
        this.tileIndex = tileIndex;
    }

    public Integer getImageIndex() {
        return imageIndex;
    }

    public void setImageIndex(Integer imageIndex) {
        this.imageIndex = imageIndex;
    }
}
