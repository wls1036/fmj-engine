package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description: DISABLESAVE
 * 禁止存档功能
 * @author: jianfeng.zheng
 * @since: 2021/12/30 12:11 上午
 * @history: 1.2021/12/30 created by jianfeng.zheng
 */
public class DisableSave extends Command {

    @Override
    public void execute(GameContext gameContext) {

    }

    @Override
    public void build(byte[] data, int start) {
        this.name = "禁止存档";
        this.commandIndex = this.readByteInt(data, start);
        this.length = 1;
    }

    @Override
    public String commandString() {
        return "DISABLESAVE";
    }
}
