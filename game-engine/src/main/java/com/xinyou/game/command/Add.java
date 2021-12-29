package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description: ADD n m
 * 脚标号为n的变量与数m相加，结果存到脚标号为n的变量中
 * @author: jianfeng.zheng
 * @since: 2021/12/30 12:04 上午
 * @history: 1.2021/12/30 created by jianfeng.zheng
 */
public class Add  extends Command {

    //变量索引
    private int varIndex;

    //值
    private int value;

    @Override
    public void execute(GameContext gameContext) {

    }

    @Override
    public void build(byte[] data, int start) {
        this.name = "相加";
        this.commandIndex = this.readByteInt(data, start);
        this.varIndex = this.readInt2(data, start + 1);
        this.value = this.readInt2(data, start + 3);
        this.length = 5;
    }

    @Override
    public String commandString() {
        return String.format("ADD %d %d", varIndex, value);
    }
}
