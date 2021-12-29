package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description:播放动画 example：MOVIE type team x y ctl
 * desc：播放动画，type和team为参数,(x,y)动画的相对屏幕左上角坐标的偏移
 * ctl为1时按键动画结束
 * ctl为2时背景不变
 * ctl为3时按键动画结束及背景不变
 * @author: jianfeng.zheng
 * @since: 2021/12/29 3:33 下午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public class Movie extends Command {
    //资源类型
    private int resourceType;

    //资源索引
    private int resourceIndex;

    //x坐标
    private int x;

    //y坐标
    private int y;

    //控制变量
    private int ctl;


    @Override
    public void execute(GameContext gameContext) {

    }

    @Override
    public void build(byte[] data, int start) {
        this.name = "播放动画";
        this.commandIndex = this.readByteInt(data, start);
        this.resourceType = this.readInt2(data, start + 1);
        this.resourceIndex = this.readInt2(data, start + 3);
        this.x = this.readInt2(data, start + 5);
        this.y = this.readInt2(data, start + 7);
        this.ctl = this.readInt2(data, start + 9);
        this.length = 11;
    }

    @Override
    public String commandString() {
        return String.format("MOVIE %d %d %d %d %d", resourceType, resourceIndex, x, x, ctl);
    }
}
