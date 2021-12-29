package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description: CREATEACTOR actor x y
 * 创建主角号码actor，位置为（x，y）
 * @author: jianfeng.zheng
 * @since: 2021/12/29 3:41 下午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public class CreateActor extends Command {

    //玩家
    private int actorId;

    //x
    private int x;

    //y
    private int y;

    @Override
    public void execute(GameContext gameContext) {

    }

    @Override
    public void build(byte[] data, int start) {
        this.name = "创建玩家";
        this.commandIndex = this.readByteInt(data, start);
        this.actorId = this.readInt2(data, start + 1);
        this.x = this.readInt2(data, start + 3);
        this.y = this.readInt2(data, start + 5);
        this.length = 7;
    }

    @Override
    public String commandString() {
        return String.format("CREATEACTOR %d %d %d", actorId, x, y);
    }
}
