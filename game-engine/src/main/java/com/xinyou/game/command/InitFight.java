package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description: INITFIGHT f0 f1 f2 f3 f4 f5 f6 f7 scrb scrl scrr
 * 初始化随即战斗参数并开启随机战斗，f0-f7为可能出现的敌人的种类，scrb为大战斗背景，scrl为左下角图，scrr为右上角图
 * @author: jianfeng.zheng
 * @since: 2021/12/29 7:01 下午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public class InitFight extends Command {

    //1-7敌人编号
    private int[] monsterIndex = new int[8];

    //战斗背景图索引
    private int backGroundIndex;

    //左下角图
    private int leftImageIndex;

    //右下角图
    private int rightImageIndex;


    @Override
    public void execute(GameContext gameContext) {

    }

    @Override
    public void build(byte[] data, int start) {
        this.name = "初始化对战";
        this.commandIndex = this.readByteInt(data, start);
        for (int i = 0; i < 8; ++i) {
            monsterIndex[i] = this.readInt2(data, start + 1 + i * 2);
        }
        this.backGroundIndex = this.readInt2(data, start + 1 + 16);
        this.leftImageIndex = this.readInt2(data, start + 1 + 18);
        this.rightImageIndex = this.readInt2(data, start + 1 + 20);
        this.length = 23;
    }

    @Override
    public String commandString() {
        return String.format("INITFIGHT %d %d %d %d %d %d %d %d %d %d %d",
                monsterIndex[0], monsterIndex[1], monsterIndex[2], monsterIndex[3],
                monsterIndex[4], monsterIndex[5], monsterIndex[6], monsterIndex[7],
                backGroundIndex, leftImageIndex, rightImageIndex);
    }
}
