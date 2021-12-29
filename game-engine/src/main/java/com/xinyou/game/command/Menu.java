package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description: MENU choice
 * 多项选择菜单，"......"为菜单项字符，项与项间以空格分开（如"离开 继续前进 瞬移"），项数不限；选择结果存放在脚标号为choice的变量中，0为跳出没选择，其他值为选中项序号
 * @author: jianfeng.zheng
 * @since: 2021/12/30 12:09 上午
 * @history: 1.2021/12/30 created by jianfeng.zheng
 */
public class Menu extends Command {

    //说话的附带贴图号，0为没有贴图
    private int varIndex;

    //说话内容
    private String text;

    @Override
    public void execute(GameContext gameContext) {

    }

    @Override
    public void build(byte[] data, int start) {
        this.name = "菜单";
        this.commandIndex = this.readByteInt(data, start);
        this.varIndex = this.readByteInt(data, start + 1);
        this.text = this.readString(data, start + 3);
        this.length = 3 + this.stringBytes(data, start + 3) + 1;
    }

    @Override
    public String commandString() {
        return String.format("MENU %d \"%s\"", varIndex, text);
    }

}
