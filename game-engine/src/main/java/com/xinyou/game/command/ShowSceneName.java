package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description: SHOWSCENENAME
 * 显示场景名称
 * @author: jianfeng.zheng
 * @since: 2021/12/29 5:06 下午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public class ShowSceneName extends Command {

    @Override
    public void execute(GameContext gameContext) {

    }

    @Override
    public void build(byte[] data, int start) {
        this.name = "显示场景名称";
        this.commandIndex = this.readByteInt(data, start);
        this.length = 1;
    }

    @Override
    public String commandString() {
        return "SHOWSCENENAME";
    }
}
