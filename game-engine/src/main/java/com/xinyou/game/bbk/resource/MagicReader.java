package com.xinyou.game.bbk.resource;

import com.xinyou.game.GameContext;
import com.xinyou.game.bbk.RomBlock;
import com.xinyou.game.resource.GameMagic;

/**
 * @Description: 魔法
 * @author: jianfeng.zheng
 * @since: 2021/12/28 4:26 下午
 * @history: 1.2021/12/28 created by jianfeng.zheng
 */
public class MagicReader extends ResourceReader<GameMagic> {


    public MagicReader(byte[] rom, RomBlock block, GameContext context) {
        super(rom, block, context);
    }

    @Override
    public GameMagic read() {
        int offset = this.block.getOffset();
        int type = rom[offset] & 0xFF;
        int index = rom[offset + 1] & 0xFF;
        if (((int)rom[offset + 2] & 0xff) > 0x70) { // 魔法描述过长
            rom[offset + 0x70] = 0;
        }
        String name = this.readString(offset + 6);
        String desc = this.readString(offset + 0x1a);
//        System.out.println("name==>" + name);
//        System.out.println(desc);
        return null;
    }
}
