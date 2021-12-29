package com.xinyou.game.bbk;

import com.alibaba.fastjson.JSON;
import com.xinyou.game.GameContext;
import com.xinyou.game.bbk.resource.*;
import com.xinyou.game.exception.LoadException;
import com.xinyou.game.resource.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2021/12/25 9:59 上午
 * @history: 1.2021/12/25 created by jianfeng.zheng
 */
public class RomReader {

    /**
     * 默认字符编码
     */
    public static String DEFAULT_ENCODING = "GBK";

    /**
     * BBK RPG游戏ROM魔法值
     */
    public static String BBK_ROM_MAGIC = "LIB";

    /**
     * 资源偏移量
     */
    public static int OFFSET_RESOURCE = 0x10;

    /**
     * 资源块索引块偏移量
     */
    public static int OFFSET_RESOURCE_BLOCK_INDEX = 0x2000;

    /**
     * 资源块偏移量
     */
    public static int OFFSET_RESOURCE_BLOCK = 0x4000;

    /**
     * 游戏上下文
     */
    private GameContext context;

    /**
     * ROM数据
     */
    private byte[] romData;

    /**
     * ROM块索引
     */
    private BlockContainer blockContainer;

    public RomReader(GameContext context) {
        this.context = context;
        this.blockContainer = new BlockContainer();
    }

    /**
     * 加载游戏ROM文件
     *
     * @param lib
     */
    public void loadRom(String lib) {
        this.romData = this.readRomData(lib);
        //1. 读取游戏基本信息
        this.readGameInfo();

        //2. 读取数据块信息
        this.readFileBlock();

//        //3. 读取图片资源
        //   this.readImages();

        //2. 读取贴图
        //     this.readTile();

        //3. 读取地图资源
        // this.readGameMap();

        //4. 读取特效资源
        // this.readGameSrs();

        //5. 读取角色资源
        // this.readCharacter();

        //6. 读取魔法资源
        // this.readMagic();

        //7. 读取装备
        // this.readGoods();

        //8. 读取脚本
        this.readScript();

        // this.print();
    }

    /**
     * 读取脚本
     */
    private void readScript() {
        List<RomBlock> blocks = blockContainer.getBlocks(Constant.RESOURCE_GUT);
        for (RomBlock block : blocks) {
            ScriptReader reader = new ScriptReader(this.romData, block, context);
            GameScript script = reader.read();
            context.addResource(block.buildResourceIndex(), script);
        }
    }

    /**
     * 读取装备
     */
    private void readGoods() {
        List<RomBlock> blocks = blockContainer.getBlocks(Constant.RESOURCE_GRS);
        for (RomBlock block : blocks) {
            GoodsReader goodsReader = new GoodsReader(this.romData, block, context);
            GameGoods goods = goodsReader.read();
            context.addResource(block.buildResourceIndex(), goods);
        }
    }

    private void readMagic() {
        List<RomBlock> blocks = blockContainer.getBlocks(Constant.RESOURCE_MRS);
        for (RomBlock block : blocks) {
            MagicReader magicReader = new MagicReader(this.romData, block, context);
            GameMagic magic = magicReader.read();
            context.addResource(block.buildResourceIndex(), magic);
        }
    }

    /**
     * 读取角色资源
     */
    private void readCharacter() {
        List<RomBlock> blocks = blockContainer.getBlocks(Constant.RESOURCE_ARS);
        for (RomBlock block : blocks) {
            Object resource = null;
            if (block.getResourceType() == 1) {
                //玩家
                ActorReader actorReader = new ActorReader(this.romData, block, context);
                resource = actorReader.read();
            } else if (block.getResourceType() == 3) {
                //怪物
                MonsterReader monsterReader = new MonsterReader(this.romData, block, context);
                resource = monsterReader.read();
            } else if (block.getResourceType() == 2) {
                //NPC
                NPCReader npcReader = new NPCReader(this.romData, block, context);
                resource = npcReader.read();
            } else if (block.getResourceType() == 4) {
                //场景
                SceneReader sceneReader = new SceneReader(this.romData, block, context);
                resource = sceneReader.read();
            } else {
                continue;
            }
            context.addResource(block.buildResourceIndex(), resource);
        }
    }

    /**
     * 读取特效资源
     */
    private void readGameSrs() {
        List<RomBlock> blocks = blockContainer.getBlocks(Constant.RESOURCE_SRS);
        for (RomBlock block : blocks) {
            SrsReader srsReader = new SrsReader(this.romData, block, context);
            GameSrs gameSrs = srsReader.read();
            context.addResource(block.buildResourceIndex(), gameSrs);
        }
    }

    /**
     * 读取贴图
     */
    private void readTile() {
        List<RomBlock> blocks = blockContainer.getBlocks(Constant.RESOURCE_TIL);
        for (RomBlock block : blocks) {
            ImageReader imageReader = new ImageReader(this.romData, block);
            List<Bitmap> images = imageReader.readImages();
            context.addResource(block.buildResourceIndex(), new GameTile(images));
        }
    }

    /**
     * 读取地图资源
     */
    private void readGameMap() {
        List<RomBlock> blocks = blockContainer.getBlocks(Constant.RESOURCE_MAP);
        for (RomBlock block : blocks) {
            GameMapReader reader = new GameMapReader(this.romData, block, context);
            GameMap map = reader.read();
            map.setTile(this.context.getResource(Constant.RESOURCE_TIL, 1, map.getTileIndex(), GameTile.class));
            // if("百草地".equals(map.getGameName())) {
            map.save();
            // }
            this.context.addResource(block.buildResourceIndex(), map);
        }
    }

    /**
     * 读取图片资源
     */
    private void readImages() {
        List<RomBlock> blockList = blockContainer.getImageBlocks();
        int index = 1;
        for (RomBlock block : blockList) {
            ImageReader imageReader = new ImageReader(this.romData, block);
            List<Bitmap> bitmaps = imageReader.readImages();
            this.context.addResource(block.buildResourceIndex(), new Bitmaps(bitmaps));
            this.context.addResourceOffset(block.buildResourceIndex(), block);
//            for (Bitmap bitmap : bitmaps) {
//                String fileName = String.format("%s-%s-%s-%s", block.getFileType(), block.getResourceType(), block.getResourceNumber(), index++);
//                String name = String.format("/Users/asan/workspace/prod/fmj-service/images/%s.png", fileName);
//                bitmap.save(name);
//            }
        }
    }

    /**
     * 读取游戏基本信息
     */
    private void readGameInfo() {
        String gameName = this.readString(0);
        if (!gameName.startsWith(BBK_ROM_MAGIC)) {
            throw new IllegalArgumentException("无法识别LIB文件");
        }
        this.context.setGameName(gameName.substring(3));
    }

    /**
     * 读取字符串
     *
     * @param offset
     * @return
     */
    private String readString(int offset) {
        int size = 0;
        while (this.romData[offset + size] != 0) {
            ++size;
        }
        byte[] buf = new byte[size];
        System.arraycopy(this.romData, offset, buf, 0, size);
        String text = null;
        try {
            text = new String(buf, DEFAULT_ENCODING);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return text;
    }

    /**
     * 读取ROM数据
     *
     * @param lib
     * @return
     */
    private byte[] readRomData(String lib) {
        try {
            FileInputStream input = new FileInputStream(new File(lib));
            byte[] buf = new byte[input.available()];
            input.read(buf);
            input.close();
            return buf;
        } catch (Exception e) {
            throw new LoadException(e);
        }
    }

    /**
     * 读取文件块信息
     */
    private void readFileBlock() {
        int index = OFFSET_RESOURCE;
        int blockIndex = OFFSET_RESOURCE_BLOCK_INDEX;
        while (this.romData[index] != -1) {
            RomBlock block = new RomBlock();
            block.setFileType(romData[index++] & 0xFF);
            block.setResourceType(romData[index++] & 0xFF);
            block.setResourceIndex(romData[index++] & 0xFF);
            block.setBlockIndex(romData[blockIndex++] & 0xFF);
            block.setOffsetLow(romData[blockIndex++] & 0xFF);
            block.setOffsetHigh(romData[blockIndex++] & 0xFF);
            block.setOffset(block.getBlockIndex() * OFFSET_RESOURCE_BLOCK | (block.getOffsetHigh() << 8 | block.getOffsetLow()));
            blockContainer.addBlock(block);
        }
    }


    public void print() {
        System.out.println("gameName==>" + context.getGameName());
        System.out.println("block===>");
        System.out.println(JSON.toJSONString(this.blockContainer));
    }
}
