package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description: GAINGOODS type index
 * 获得物品，类型为type，号码为index
 * @author: jianfeng.zheng
 * @since: 2021/12/29 10:02 下午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public class GainGoods extends Command {

    //事件编号
    private int goodType;

    //目标地址
    private int goodIndex;

    @Override
    public void execute(GameContext gameContext) {

    }

    @Override
    public void build(byte[] data, int start) {
        this.name = "获得物品";
        this.commandIndex = this.readByteInt(data, start);
        this.goodType = this.readInt2(data, start + 1);
        this.goodIndex = this.readInt2(data, start + 3);
        this.length = 5;
    }

    @Override
    public String commandString() {
        return String.format("GAINGOODS %d %d", goodType, goodIndex);
    }
}
