package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description: SETEVENT n
 * 将事件n标志设置为1
 * @author: jianfeng.zheng
 * @since: 2021/12/29 4:25 下午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public class SetEvent extends Command {
    //事件编号
    private int eventId;

    @Override
    public void execute(GameContext gameContext) {

    }

    @Override
    public void build(byte[] data, int start) {
        this.name = "标记事件";
        this.commandIndex = this.readByteInt(data, start);
        this.eventId = this.readInt2(data, start + 1);
        this.length = 3;
    }

    @Override
    public String commandString() {
        return String.format("SETEVENT %d", eventId);
    }
}
