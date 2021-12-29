package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description: 显示字幕指令
 * SHOWGUT toppic botpic "......"
 * 显示字幕，toppic和botpic为字幕"......"的上下加修饰的图片号
 * @author: jianfeng.zheng
 * @since: 2021/12/29 1:32 下午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public class ShowGut extends Command {

    private int topImage;

    private int bottomImage;

    private String text;

    @Override
    public void execute(GameContext gameContext) {

    }

    /**
     * 构建命令
     *
     * @param data
     * @param start
     */
    @Override
    public void build(byte[] data, int start) {
        this.name = "字幕展示";
        this.commandIndex = this.readByteInt(data, start);
        this.topImage = this.readInt2(data, start + 1);
        this.bottomImage = this.readInt2(data, start + 3);
        this.text = this.readString(data, start + 5);
        //+1表示加上最后一个0
        this.length = 5 + this.stringBytes(data, start + 5) + 1;
    }

    @Override
    public String commandString() {
        return String.format("SHOWGUT %d %d \"%s\"", this.topImage, this.bottomImage, this.text);
    }
}
