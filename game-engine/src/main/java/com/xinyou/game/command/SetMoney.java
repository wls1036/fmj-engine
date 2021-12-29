package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description: SETMONEY money
 * 设置现钱数目为money
 * @author: jianfeng.zheng
 * @since: 2021/12/29 4:27 下午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public class SetMoney extends Command {

    //金钱
    private int money;

    @Override
    public void execute(GameContext gameContext) {

    }

    @Override
    public void build(byte[] data, int start) {
        this.name = "获取金钱";
        this.commandIndex = this.readByteInt(data, start);
        this.money = this.readInt4(data, start + 1);
        this.length = 5;
    }

    @Override
    public String commandString() {
        return String.format("SETMONEY %d", money);
    }
}
