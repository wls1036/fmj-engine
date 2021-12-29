package com.xinyou.game.resource;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2021/12/29 6:34 下午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public class SceneEvent {

    public static final String EVENT_MAP = "地图事件";
    public static final String EVENT_NPC = "NPC事件";
    public static final String EVENT_OTHER = "其他事件";

    //事件类型
    private String type;
    private int eventIndex;
    private int commandIndex;


    public SceneEvent(String type, int eventIndex, int commandIndex) {
        this.type = type;
        this.eventIndex = eventIndex;
        this.commandIndex = commandIndex;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getEventIndex() {
        return eventIndex;
    }

    public void setEventIndex(int eventIndex) {
        this.eventIndex = eventIndex;
    }

    public int getCommandIndex() {
        return commandIndex;
    }

    public void setCommandIndex(int commandIndex) {
        this.commandIndex = commandIndex;
    }
}
