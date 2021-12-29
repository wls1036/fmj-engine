package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description: DELETEACTOR actor
 * 主角角色离队，从角色队列中删除指定主角号码actor的角色
 * @author: jianfeng.zheng
 * @since: 2021/12/29 11:55 下午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public class DeleteActor extends Command {
    //角色编号
    private int actorId;


    @Override
    public void execute(GameContext gameContext) {

    }

    @Override
    public void build(byte[] data, int start) {
        this.name = "删除主角";
        this.commandIndex = this.readByteInt(data, start);
        this.actorId = this.readInt2(data, start + 1);
        this.length = 3;
    }

    @Override
    public String commandString() {
        return String.format("DELETEACTOR %d", actorId);
    }
}
