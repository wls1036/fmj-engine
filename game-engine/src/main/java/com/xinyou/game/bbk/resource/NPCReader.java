package com.xinyou.game.bbk.resource;

import com.xinyou.game.GameContext;
import com.xinyou.game.bbk.Constant;
import com.xinyou.game.bbk.RomBlock;
import com.xinyou.game.resource.Bitmaps;
import com.xinyou.game.resource.GameNPC;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2021/12/28 3:58 下午
 * @history: 1.2021/12/28 created by jianfeng.zheng
 */
public class NPCReader extends ResourceReader<GameNPC> {


    public NPCReader(byte[] rom, RomBlock block, GameContext context) {
        super(rom, block, context);
    }

    @Override
    public GameNPC read() {
        int offset = this.block.getOffset();
        int type = rom[offset] & 0xFF;
        int index = rom[offset + 1] & 0xFF;
        String name = this.readString(offset + 9);
//        Bitmaps fighting = context.getResource(Constant.RESOURCE_ACP, 2, (int) rom[offset + 0x16] & 0xFF, Bitmaps.class);
//        fighting.save("/Users/asan/workspace/prod/fmj-service/图片/NPC", name);
        return null;
    }
}
