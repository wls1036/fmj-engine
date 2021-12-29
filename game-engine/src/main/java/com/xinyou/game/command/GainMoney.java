package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description: GAINMONEY money
 * 得到数目为money的钱
 * @author: jianfeng.zheng
 * @since: 2021/12/29 10:57 下午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public class GainMoney extends Command {

    //金钱
    private int money;


    @Override
    public void execute(GameContext gameContext) {

    }

    @Override
    public void build(byte[] data, int start) {
        this.name = "获得金钱";
        this.commandIndex = this.readByteInt(data, start);
        this.money = this.readInt4(data, start + 1);
        this.length = 5;
    }

    @Override
    public String commandString() {
        return String.format("GAINMONEY %d", money);
    }
}
