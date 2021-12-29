package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description: SETSCENENAME "..."
 * 设置场景名称，五个汉字以内。
 * @author: jianfeng.zheng
 * @since: 2021/12/29 5:03 下午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public class SetSceneName extends Command {

    //场景名称
    private String text;


    @Override
    public void execute(GameContext gameContext) {

    }

    @Override
    public void build(byte[] data, int start) {
        this.name = "设置场景名称";
        this.commandIndex = this.readByteInt(data, start);
        this.text = this.readString(data, start + 1);
        this.length = 1 + this.stringBytes(data, start + 1) + 1;
    }

    @Override
    public String commandString() {
        return String.format("SETSCENENAME \"%s\"", text);
    }
}
