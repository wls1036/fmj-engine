package com.xinyou.game.bbk.resource;

import com.xinyou.game.GameContext;
import com.xinyou.game.bbk.RomBlock;
import com.xinyou.game.resource.GameMap;
import com.xinyou.game.resource.MapBlock;

import java.io.UnsupportedEncodingException;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2021/12/25 3:23 下午
 * @history: 1.2021/12/25 created by jianfeng.zheng
 */
public class GameMapReader extends ResourceReader<GameMap> {

    public GameMapReader(byte[] rom, RomBlock block, GameContext context) {
        super(rom, block, context);
    }

    @Override
    public GameMap read() {
        int offset = this.block.getOffset();
        int type = rom[offset] & 0xFF;
        int index = rom[offset + 1] & 0xFF;
        int tileIndex = rom[offset + 2] & 0xFF;
        String name = this.readString(offset + 3);
        int width = rom[offset + 0x10];
        int mHeight = rom[offset + 0x11];

        GameMap gameMap = new GameMap(width, mHeight);
        gameMap.setGameName(name);
        gameMap.setTileIndex(tileIndex);
        int len = width * mHeight * 2;

        byte[] mData = new byte[len];
        System.arraycopy(rom, offset + 0x12, mData, 0, len);
        for (int i = 0; i < len; i = i + 2) {
            byte low = mData[i];
            byte high = mData[i + 1];
            MapBlock mapBlock = new MapBlock();
            mapBlock.setCanWalk((low & 0x80) != 0);
            mapBlock.setEventIndex(high & 0xFF);
            mapBlock.setTileIndex(tileIndex);
            mapBlock.setImageIndex(low & 0x7F);
            gameMap.setMapBlock(i / 2, mapBlock);
        }
        return gameMap;
    }
}
