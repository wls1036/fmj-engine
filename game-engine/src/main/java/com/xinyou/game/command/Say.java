package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description: SAY pos "......"
 * 将""中的内容打印到屏幕上，pos为说话的附带贴图号，0为没有贴图
 * @author: jianfeng.zheng
 * @since: 2021/12/29 4:07 下午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public class Say extends Command {

    //说话的附带贴图号，0为没有贴图
    private int imageIndex;

    //说话内容
    private String text;

    @Override
    public void execute(GameContext gameContext) {

    }

    @Override
    public void build(byte[] data, int start) {
        this.name = "对话";
        this.commandIndex = this.readByteInt(data, start);
        this.imageIndex = this.readByteInt(data, start + 1);
        this.text = this.readString(data, start + 3);
        this.length = 3 + this.stringBytes(data, start + 3) + 1;
    }

    @Override
    public String commandString() {
        return String.format("SAY %d \"%s\"", imageIndex, text);
    }


}
