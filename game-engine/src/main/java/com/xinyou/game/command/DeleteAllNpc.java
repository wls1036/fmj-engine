package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description: DELALLNPC
 * 删除所有NPC
 * @author: jianfeng.zheng
 * @since: 2021/12/29 5:10 下午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public class DeleteAllNpc extends Command {
    @Override
    public void execute(GameContext gameContext) {

    }

    @Override
    public void build(byte[] data, int start) {
        this.name = "删除所有NPC";
        this.commandIndex = this.readByteInt(data, start);
        this.length = 1;
    }

    @Override
    public String commandString() {
        return "DELALLNPC";
    }
}
