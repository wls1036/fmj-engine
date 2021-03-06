package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description: DELETEBOX id
 * 删除操作号为id的宝箱
 * @author: jianfeng.zheng
 * @since: 2021/12/29 9:16 下午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public class DeleteBox extends Command {

    //箱子ID
    private int boxId;

    @Override
    public void execute(GameContext gameContext) {

    }

    @Override
    public void build(byte[] data, int start) {
        this.name = "删除宝箱";
        this.commandIndex = this.readByteInt(data, start);
        this.boxId = this.readInt2(data, start + 1);
        this.length = 3;
    }

    @Override
    public String commandString() {
        return String.format("DELETEBOX %d", boxId);
    }
}
