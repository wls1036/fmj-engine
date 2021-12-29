package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description: DELETENPC id
 * 删除操作号为id的配角
 * @author: jianfeng.zheng
 * @since: 2021/12/29 4:23 下午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public class DeleteNpc extends Command {
    //npc编号
    private int npcId;


    @Override
    public void execute(GameContext gameContext) {

    }

    @Override
    public void build(byte[] data, int start) {
        this.name = "删除NPC";
        this.commandIndex = this.readByteInt(data, start);
        this.npcId = this.readInt2(data, start + 1);
        this.length = 3;
    }

    @Override
    public String commandString() {
        return String.format("DELETENPC %d", npcId);
    }
}
