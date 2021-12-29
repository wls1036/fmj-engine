package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description: RESUMEACTORHP id rade
 * 恢复角色id生命rade%(一般用于剧情战斗失败,而游戏继续)
 * @author: jianfeng.zheng
 * @since: 2021/12/29 11:16 下午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public class ResumeActorHP extends Command {

    //主角编号
    private int actorId;

    //恢复百分比
    private int rate;

    @Override
    public void execute(GameContext gameContext) {

    }

    @Override
    public void build(byte[] data, int start) {
        this.name = "恢复HP";
        this.commandIndex = this.readByteInt(data, start);
        this.actorId = this.readInt2(data, start + 1);
        this.rate = this.readInt2(data, start + 3);
        this.length = 5;
    }

    @Override
    public String commandString() {
        return String.format("RESUMEACTORHP %d %d", actorId, rate);
    }
}

