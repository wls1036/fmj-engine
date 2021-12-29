package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description: CLREVENT n
 * 将事件n标志设置为0
 * @author: jianfeng.zheng
 * @since: 2021/12/29 9:59 下午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public class ClrEvent extends Command {

    //事件ID
    private int eventId;

    @Override
    public void execute(GameContext gameContext) {

    }

    @Override
    public void build(byte[] data, int start) {
        this.name = "清除标记";
        this.commandIndex = this.readByteInt(data, start);
        this.eventId = this.readInt2(data, start + 1);
        this.length = 3;
    }

    @Override
    public String commandString() {
        return String.format("CLREVENT %d", eventId);
    }
}
