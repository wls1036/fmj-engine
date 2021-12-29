package com.xinyou.game.bbk.resource;

import com.xinyou.game.GameContext;
import com.xinyou.game.bbk.Constant;
import com.xinyou.game.bbk.RomBlock;
import com.xinyou.game.resource.Bitmaps;
import com.xinyou.game.resource.GameGoods;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2021/12/28 4:48 下午
 * @history: 1.2021/12/28 created by jianfeng.zheng
 */
public class GoodsReader extends ResourceReader<GameGoods> {


    public GoodsReader(byte[] rom, RomBlock block, GameContext context) {
        super(rom, block, context);
    }

    @Override
    public GameGoods read() {
        int offset = this.block.getOffset();
        int type = rom[offset] & 0xFF;
        int index = rom[offset + 1] & 0xFF;
        String name = this.readString(offset + 6);
        String description = this.readString(offset + 0x1e);
        Bitmaps fighting = context.getResource(Constant.RESOURCE_GDP, type, (int) rom[offset + 5] & 0xFF, Bitmaps.class);
        // fighting.save("/Users/asan/workspace/prod/fmj-service/图片/物品", name);
        //System.out.println("name==>" + name);
        // System.out.println(description);
        if (name.equals("钨龙剑")) {
            System.out.println("name==>" + name);
            System.out.println(description);
            System.out.println("index==>" + index);
            System.out.println("type==>" + type);
        }
        return null;
    }
}
