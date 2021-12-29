package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description: ENTERFIGHT roundmax f0 f1 f2 scrb scrl scrr evtrnd0 evtrnd1 evtrnd2 evt0 evt1 evt2 lossto winto
 * 进入战斗，roundmax为限定最多回合数（0为无限）
 * f0-f2为敌人
 * evtrnd0-evtrnd2为战斗触发事件回合
 * evt0-evt2为相应的事件号
 * lossto为战斗失败时跳转到的地址标号
 * winto为战斗胜利时跳转到的地址标号
 * scrb为大战斗背景
 * scrl为左下角图
 * scrr为右上角图
 * @author: jianfeng.zheng
 * @since: 2021/12/29 9:27 下午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public class EnterFight extends Command {

    //最大回合数
    private int roundMax;

    //怪物1
    private int monster1;

    //怪物2
    private int monster2;

    //怪物3
    private int monster3;

    //战斗背景图索引
    private int backGroundIndex;

    //左下角图
    private int leftImageIndex;

    //右下角图
    private int rightImageIndex;

    //战斗触发事件回合
    private int event1Round;

    //战斗触发事件回合
    private int event2Round;

    //战斗触发事件回合
    private int event3Round;

    //event1Round触发的事件
    private int event1;

    //event2Round触发的事件
    private int event2;

    //event3Round触发的事件
    private int event3;

    //战斗成功跳转的地址
    private int winto;

    //战斗失败跳转的地址
    private int lossto;


    @Override
    public void execute(GameContext gameContext) {

    }

    @Override
    public void build(byte[] data, int start) {
        this.name = "进入战斗";
        this.commandIndex = this.readByteInt(data, start);
        this.roundMax = this.readInt2(data, start + 1);
        this.monster1 = this.readInt2(data, start + 3);
        this.monster2 = this.readInt2(data, start + 5);
        this.monster3 = this.readInt2(data, start + 7);
        this.backGroundIndex = this.readInt2(data, start + 9);
        this.leftImageIndex = this.readInt2(data, start + 11);
        this.rightImageIndex = this.readInt2(data, start + 13);
        this.event1Round = this.readInt2(data, start + 15);
        this.event2Round = this.readInt2(data, start + 17);
        this.event3Round = this.readInt2(data, start + 19);
        this.event1 = this.readInt2(data, start + 21);
        this.event2 = this.readInt2(data, start + 23);
        this.event3 = this.readInt2(data, start + 25);
        this.lossto = this.readInt2(data, start + 27);
        this.winto = this.readInt2(data, start + 29);
        this.length = 31;
    }

    @Override
    public String commandString() {
        return String.format("ENTERFIGHT %d %d %d %d %d %d %d %d %d %d %d %d %d %d %d", roundMax,
                monster1, monster2, monster3, backGroundIndex, leftImageIndex, rightImageIndex,
                event1Round, event2Round, event3Round, event1, event2, event3,
                lossto, winto);
    }
}
