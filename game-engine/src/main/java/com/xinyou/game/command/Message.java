package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description: MESSAGE "..."
 * 用消息框显示"..."中信息（每行最多显示8个汉字，最多可显示5行），等待按键才返回。
 * @author: jianfeng.zheng
 * @since: 2021/12/29 9:54 下午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public class Message extends Command {

    //说话内容
    private String text;

    @Override
    public void execute(GameContext gameContext) {

    }

    @Override
    public void build(byte[] data, int start) {
        this.name = "显示消息";
        this.commandIndex = this.readByteInt(data, start);
        this.text = this.readString(data, start + 1);
        this.length = 1 + this.stringBytes(data, start + 1) + 1;
    }

    @Override
    public String commandString() {
        return String.format("MESSAGE \"%s\"", text);
    }


}
