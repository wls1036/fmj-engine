package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description: SALE
 * 卖出
 * @author: jianfeng.zheng
 * @since: 2021/12/29 11:57 下午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public class Sale extends Command {

    @Override
    public void execute(GameContext gameContext) {

    }

    @Override
    public void build(byte[] data, int start) {
        this.name = "卖出";
        this.commandIndex = this.readByteInt(data, start);
        this.length = 1;
    }

    @Override
    public String commandString() {
        return "SALE";
    }
}

