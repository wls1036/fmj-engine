package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description: LEARNMAGIC actor type index
 * 号码actor的主角学会法术类型为type，序号为index的法术
 * @author: jianfeng.zheng
 * @since: 2021/12/30 12:00 上午
 * @history: 1.2021/12/30 created by jianfeng.zheng
 */
public class LearnMagic extends Command {

    //主角
    private int actorId;

    //法术类型
    private int magicType;

    //法术索引
    private int magicIndex;

    @Override
    public void execute(GameContext gameContext) {

    }

    @Override
    public void build(byte[] data, int start) {
        this.name = "学会法术";
        this.commandIndex = this.readByteInt(data, start);
        this.actorId = this.readInt2(data, start + 1);
        this.magicType = this.readInt2(data, start + 3);
        this.magicIndex = this.readInt2(data, start + 5);
        this.length = 7;
    }

    @Override
    public String commandString() {
        return String.format("LEARNMAGIC %d %d %d", actorId, magicType, magicIndex);
    }
}
