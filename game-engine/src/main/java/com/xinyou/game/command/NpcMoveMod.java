package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description: NPCMOVEMOD id mode
 * 配角的运动模式，id为操作号，mode为 1 时随机运动，为 0 时原地不动,为 4 激活状态一直换图片，不改变位置（适合动态的物品对象）
 * @author: jianfeng.zheng
 * @since: 2021/12/29 11:52 下午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public class NpcMoveMod extends Command {

    //npc编号
    private int npcIndex;

    //mode为 1 时随机运动，为 0 时原地不动,为 4 激活状态一直换图片，不改变位置
    private int mode;

    @Override
    public void execute(GameContext gameContext) {

    }

    @Override
    public void build(byte[] data, int start) {
        this.name = "设置NPC运动模式";
        this.commandIndex = this.readByteInt(data, start);
        this.npcIndex = this.readInt2(data, start + 1);
        this.mode = this.readInt2(data, start + 3);
        this.length = 5;
    }

    @Override
    public String commandString() {
        return String.format("NPCMOVEMOD %d %d", npcIndex, mode);
    }
}
