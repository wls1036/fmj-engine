package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description: 加载地图
 * example：LOADMAP m n x y
 * desc：载入号码n,类型m的地图，初始位置（x，y）
 * @author: jianfeng.zheng
 * @since: 2021/12/29 3:16 下午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public class LoadMap extends Command {

    //地图索引
    private int mapIndex;

    //地图类型
    private int mapType;

    //初始位置x
    private int x;

    //初始位置y
    private int y;


    @Override
    public void execute(GameContext gameContext) {

    }

    @Override
    public void build(byte[] data, int start) {
        this.name = "加载地图";
        this.commandIndex = this.readByteInt(data, start);
        this.mapIndex = this.readInt2(data, start + 1);
        this.mapType = this.readInt2(data, start + 3);
        this.x = this.readInt2(data, start + 5);
        this.y = this.readInt2(data, start + 7);
        this.length = 9;
    }

    @Override
    public String commandString() {
        return String.format("LOADMAP %d %d %d %d", mapIndex, mapType, x, y);
    }
}
