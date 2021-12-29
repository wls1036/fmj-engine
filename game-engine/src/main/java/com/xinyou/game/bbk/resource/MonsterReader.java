package com.xinyou.game.bbk.resource;

import com.xinyou.game.GameContext;
import com.xinyou.game.bbk.Constant;
import com.xinyou.game.bbk.RomBlock;
import com.xinyou.game.resource.Bitmap;
import com.xinyou.game.resource.Bitmaps;
import com.xinyou.game.resource.GameMonster;

import java.util.List;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2021/12/28 2:53 下午
 * @history: 1.2021/12/28 created by jianfeng.zheng
 */
public class MonsterReader extends ResourceReader<GameMonster> {

    public MonsterReader(byte[] rom, RomBlock block, GameContext context) {
        super(rom, block, context);
    }

    @Override
    public GameMonster read() {
        int offset = this.block.getOffset();
        int type = rom[offset] & 0xFF;
        int index = rom[offset + 1] & 0xFF;
        String name = this.readString(offset + 6);
        Bitmaps fighting = context.getResource(Constant.RESOURCE_ACP, type, (int) rom[offset + 0x2e] & 0xFF, Bitmaps.class);
        if (name == null || name.trim().length() == 0) {
            name = String.valueOf(offset);
        }
     //   fighting.save("/Users/asan/workspace/prod/fmj-service/ars", name);
        return null;
    }
}
