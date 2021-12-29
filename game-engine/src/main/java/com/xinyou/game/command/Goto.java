package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description: GOTO label
 * 跳转到脚本地址标号为label处运行
 * @author: jianfeng.zheng
 * @since: 2021/12/29 7:20 下午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public class Goto extends Command {
    //目标地址
    private int targetAddress;

    @Override
    public void execute(GameContext gameContext) {

    }

    @Override
    public void build(byte[] data, int start) {
        this.name = "跳转";
        this.commandIndex = this.readByteInt(data, start);
        this.targetAddress = this.readInt2(data, start + 3);
        this.length = 3;
    }

    @Override
    public String commandString() {
        return String.format("GOTO %d", targetAddress);
    }
}
