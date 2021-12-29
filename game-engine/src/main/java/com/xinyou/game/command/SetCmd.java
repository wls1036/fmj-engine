package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description: SET n m
 * 脚标号为n的变量内容为m
 * @author: jianfeng.zheng
 * @since: 2021/12/29 11:14 下午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public class SetCmd extends Command {

    //变量索引
    private int varIndex;

    //值
    private int value;

    @Override
    public void execute(GameContext gameContext) {

    }

    @Override
    public void build(byte[] data, int start) {
        this.name = "设置值";
        this.commandIndex = this.readByteInt(data, start);
        this.varIndex = this.readInt2(data, start + 1);
        this.value = this.readInt2(data, start + 3);
        this.length = 5;
    }

    @Override
    public String commandString() {
        return String.format("SET %d %d", varIndex, value);
    }
}
