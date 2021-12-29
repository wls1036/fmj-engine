package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description: USEGOODS type index erradr
 * 使用物品链中的一个物品（type，index），如果物品链中无此物品即跳到erradr处执行
 * @author: jianfeng.zheng
 * @since: 2021/12/29 10:06 下午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public class UserGoods extends Command {

    //物品类型
    private int goodType;

    //物品索引
    private int goodIndex;

    //如果物品链中无此物品即跳到erradr处执行
    private int gotoError;

    @Override
    public void execute(GameContext gameContext) {

    }

    @Override
    public void build(byte[] data, int start) {
        this.name = "使用物品";
        this.commandIndex = this.readByteInt(data, start);
        this.goodIndex = this.readInt2(data, start + 1);
        this.goodType = this.readInt2(data, start + 3);
        this.gotoError = this.readInt2(data, start + 5);
        this.length = 7;
    }

    @Override
    public String commandString() {
        return String.format("USEGOODS %d %d %d", goodType, goodIndex, gotoError);
    }
}
