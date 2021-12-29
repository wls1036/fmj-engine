package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description: NPCSTEP id faceto step
 * id角色，0为主角,faceto 面向，step 脚步
 * @author: jianfeng.zheng
 * @since: 2021/12/29 3:53 下午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public class NpcStep extends Command {

    //npc编号 0为主角
    private int npcIndex;

    //朝向 0:北 1:东 2:南 3:西
    private int faceTo;

    //脚步
    private int step;


    @Override
    public void execute(GameContext gameContext) {

    }

    @Override
    public void build(byte[] data, int start) {
        this.name = "NPC移动";
        this.commandIndex = this.readByteInt(data, start);
        this.npcIndex = this.readInt2(data, start + 1);
        this.faceTo = this.readInt2(data, start + 3);
        this.step = this.readInt2(data, start + 5);
        this.length = 7;
    }

    @Override
    public String commandString() {
        return String.format("NPCSTEP %s %s %s", npcIndex, faceTo, step);
    }
}
