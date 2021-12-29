package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description: RETURN
 * 返回到调用位置的下一句(和CALLBACK的区别除了返回区别外，还有一个重要的是本语句会恢复原脚本的事件跳转表等脚本信息)
 * @author: jianfeng.zheng
 * @since: 2021/12/30 12:13 上午
 * @history: 1.2021/12/30 created by jianfeng.zheng
 */
public class ReturnCmd extends Command {

    @Override
    public void execute(GameContext gameContext) {

    }

    @Override
    public void build(byte[] data, int start) {
        this.name = "返回";
        this.commandIndex = this.readByteInt(data, start);
        this.length = 1;
    }

    @Override
    public String commandString() {
        return "RETURN";
    }
}
