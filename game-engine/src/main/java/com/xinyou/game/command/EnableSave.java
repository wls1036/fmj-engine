package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description: ENABLESAVE
 * 允许存档功能
 * @author: jianfeng.zheng
 * @since: 2021/12/30 12:12 上午
 * @history: 1.2021/12/30 created by jianfeng.zheng
 */
public class EnableSave extends Command {

    @Override
    public void execute(GameContext gameContext) {

    }

    @Override
    public void build(byte[] data, int start) {
        this.name = "允许存档";
        this.commandIndex = this.readByteInt(data, start);
        this.length = 1;
    }

    @Override
    public String commandString() {
        return "ENABLESAVE";
    }
}
