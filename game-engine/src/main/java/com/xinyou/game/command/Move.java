package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description: MOVE id x y
 * 将操作号为id的NPC角色移动到（x，y）处——主角不可以移动
 * @author: jianfeng.zheng
 * @since: 2021/12/29 4:20 下午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public class Move extends Command {

    //NPC编号
    private int npcId;

    private int x;

    private int y;

    @Override
    public void execute(GameContext gameContext) {

    }

    @Override
    public void build(byte[] data, int start) {
        this.name = "移动NPC";
        this.commandIndex = this.readByteInt(data, start);
        this.npcId = this.readInt2(data, start + 1);
        this.x = this.readInt2(data, start + 3);
        this.y = this.readInt2(data, start + 5);
        this.length = 7;
    }

    @Override
    public String commandString() {
        return String.format("MOVE %d %d %d", npcId, x, y);
    }
}
