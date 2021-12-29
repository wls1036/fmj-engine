package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description: CHOICE "..." "..." adress
 * 选择框，选择第一个不跳转，选择第二个脚本跳转到地址adress处(""中的字符数为9个汉字或19个ASCII字符）
 * @author: jianfeng.zheng
 * @since: 2021/12/29 11:44 下午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public class Choice extends Command {

    //选项1
    private String item1;

    //选项2
    private String item2;

    //选择第一个不跳转，选择第二个脚本跳转到地址gotoAddress处
    private int gotoAddress;

    @Override
    public void execute(GameContext gameContext) {

    }

    @Override
    public void build(byte[] data, int start) {
        this.name = "选择";
        this.commandIndex = this.readByteInt(data, start);
        this.item1 = this.readString(data, start + 1);
        int len1 = this.stringBytes(data, start + 1) + 1;
        this.item2 = this.readString(data, start + 1 + len1);
        int len2 = this.stringBytes(data, start + 1 + len1) + 1;
        this.gotoAddress = this.readInt2(data, start + 1 + len1 + len2);
        this.length = len1 + len2 + 1 + 2;
    }

    @Override
    public String commandString() {
        return String.format("CHOICE %s %s %d", item1, item2, gotoAddress);
    }
}
