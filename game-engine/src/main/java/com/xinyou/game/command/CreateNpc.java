package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description: CREATENPC id npc x y
 * 创建配角号码npc，位置为（x，y），id为操作号
 * @author: jianfeng.zheng
 * @since: 2021/12/29 4:11 下午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public class CreateNpc extends Command {

    //npc编号
    private int npcId;

    //npc索引
    private int npcIndex;

    //x
    private int x;

    //y
    private int y;

    @Override
    public void execute(GameContext gameContext) {

    }

    @Override
    public void build(byte[] data, int start) {
        this.name = "创建NPC";
        this.commandIndex = this.readByteInt(data, start);
        this.npcId = this.readInt2(data, start + 1);
        this.npcIndex = this.readInt2(data, start + 3);
        this.x = this.readInt2(data, start + 5);
        this.y = this.readInt2(data, start + 7);
        this.length = 9;
    }

    @Override
    public String commandString() {
        return String.format("CREATENPC %d %d %d %d", npcId, npcIndex, x, y);
    }
}
