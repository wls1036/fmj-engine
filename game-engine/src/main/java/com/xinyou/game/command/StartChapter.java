package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description: STARTCHAPTER m n
 * 载入号为n，类型为m的脚本，当前脚本结束
 * @author: jianfeng.zheng
 * @since: 2021/12/29 4:46 下午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public class StartChapter extends Command {

    //脚本类型
    private int scriptType;

    //脚本索引
    private int scriptIndex;

    @Override
    public void execute(GameContext gameContext) {

    }

    @Override
    public void build(byte[] data, int start) {
        this.name = "加载脚本";
        this.commandIndex = this.readByteInt(data, start);
        this.scriptType = this.readInt2(data, start + 1);
        this.scriptIndex = this.readInt2(data, start + 3);
        this.length = 5;
    }

    @Override
    public String commandString() {
        return String.format("STARTCHAPTER %d %d", scriptType, scriptIndex);
    }
}
