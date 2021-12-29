package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description: BUY "t0 t1 ... tsum"
 * 买卖，t0 ... tsum为物品类型，每种以空格分开，在""中(最多20种)
 * @author: jianfeng.zheng
 * @since: 2021/12/29 10:11 下午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public class Buy extends Command {

    private int[] goodsType;
    private int[] goodsIndex;


    @Override
    public void execute(GameContext gameContext) {

    }

    @Override
    public void build(byte[] data, int start) {
        this.name = "购买";
        this.commandIndex = this.readByteInt(data, start);
        int length = this.stringBytes(data, start + 1);
        goodsType = new int[length / 2];
        goodsIndex = new int[length / 2];
        for (int i = 0; i < goodsType.length; ++i) {
            goodsType[i] = this.readByteInt(data, start + 1 + 2 * i + 1);
            goodsIndex[i] = this.readByteInt(data, start + 1 + 2 * i);
        }
        this.length = 1 + this.stringBytes(data, start + 1) + 1;
    }

    @Override
    public String commandString() {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < goodsIndex.length; ++i) {
            if (buf.length() > 0) {
                buf.append(" ");
            }
            buf.append(String.format("%d%03d", goodsType[i], goodsIndex[i]));
        }
        return String.format("BUY \"%s\"", buf.toString());
    }
}
