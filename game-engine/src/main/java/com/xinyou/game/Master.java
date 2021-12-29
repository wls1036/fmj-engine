package com.xinyou.game;

import com.xinyou.game.bbk.RomReader;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2021/12/25 9:57 上午
 * @history: 1.2021/12/25 created by jianfeng.zheng
 */
public class Master {

    private GameContext context;

    private RomReader romReader;

    public Master(){
        this.init();
    }

    private void init() {
        this.context = new GameContext();
        this.romReader = new RomReader(context);
    }

    /**
     * 加载ROM文件
     *
     * @param lib
     */
    public void loadGame(String lib) {
        this.romReader.loadRom(lib);
    }
}
