package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description: CREATEBOX id boxindex x y
 * 创建一个宝箱，宝箱号码boxindex，位置为（x，y），id为操作号
 * @author: jianfeng.zheng
 * @since: 2021/12/29 4:53 下午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public class CreateBox extends Command {

    //箱子编号
    private int boxId;

    //箱子索引
    private int boxIndex;

    private int x;

    private int y;

    @Override
    public void execute(GameContext gameContext) {

    }

    @Override
    public void build(byte[] data, int start) {
        this.name = "创建宝箱";
        this.commandIndex = this.readByteInt(data, start);
        this.boxId = this.readInt2(data, start + 1);
        this.boxIndex = this.readInt2(data, start + 3);
        this.x = this.readInt2(data, start + 5);
        this.y = this.readInt2(data, start + 7);
        this.length = 9;
    }

    @Override
    public String commandString() {
        return String.format("CREATEBOX %d %d %d %d", boxId, boxIndex, x, y);
    }
}
