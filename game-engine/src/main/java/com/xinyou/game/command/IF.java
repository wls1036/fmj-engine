package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description: IF n label
 * 如果事件标志为1，跳转到脚本地址标号为label处运行
 * @author: jianfeng.zheng
 * @since: 2021/12/29 7:13 下午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public class IF extends Command {

    //事件编号
    private int eventIndex;

    //目标地址
    private int targetAddress;

    @Override
    public void execute(GameContext gameContext) {

    }

    @Override
    public void build(byte[] data, int start) {
        this.name = "判断";
        this.commandIndex = this.readByteInt(data, start);
        this.eventIndex = this.readInt2(data, start + 1);
        this.targetAddress = this.readInt2(data, start + 3);
        this.length = 5;
    }

    @Override
    public String commandString() {
        return String.format("IF %d %d", eventIndex, targetAddress);
    }
}
