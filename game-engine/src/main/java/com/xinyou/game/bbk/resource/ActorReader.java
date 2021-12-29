package com.xinyou.game.bbk.resource;

import com.xinyou.game.GameContext;
import com.xinyou.game.bbk.RomBlock;
import com.xinyou.game.resource.GameActor;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2021/12/28 1:57 下午
 * @history: 1.2021/12/28 created by jianfeng.zheng
 */
public class ActorReader extends ResourceReader<GameActor> {


    public ActorReader(byte[] rom, RomBlock block, GameContext context) {
        super(rom, block, context);
    }

    @Override
    public GameActor read() {
        int offset = this.block.getOffset();
        int type = rom[offset] & 0xFF;
        int index = rom[offset + 1] & 0xFF;
        String name = this.readString(offset + 0x0a);
//        Bitmaps images = context.getResource(Constant.RESOURCE_PIC, 1, index, Bitmaps.class);
//        images.save("/Users/asan/workspace/prod/fmj-service/角色", name);
//        Bitmaps walking = context.getResource(Constant.RESOURCE_ACP, type, (int) rom[offset + 0x16] & 0xFF, Bitmaps.class);
//        walking.save("/Users/asan/workspace/prod/fmj-service/角色", name + "-行走");
//        Bitmaps fighting = context.getResource(Constant.RESOURCE_PIC, 3, index, Bitmaps.class);
//        fighting.save("/Users/asan/workspace/prod/fmj-service/角色", name + "-战斗");
        return null;
    }
}
