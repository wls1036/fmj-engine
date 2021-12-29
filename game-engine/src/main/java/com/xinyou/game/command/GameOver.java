package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description: 游戏结束
 * @author: jianfeng.zheng
 * @since: 2021/12/29 9:57 下午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public class GameOver extends Command {

    @Override
    public void execute(GameContext gameContext) {

    }

    @Override
    public void build(byte[] data, int start) {
        this.name = "游戏结束";
        this.commandIndex = this.readByteInt(data, start);
        this.length = 1;
    }

    @Override
    public String commandString() {
        return "GAMEOVER";
    }
}

