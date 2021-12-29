package com.xinyou.game.bbk.resource;

import com.xinyou.game.GameContext;
import com.xinyou.game.bbk.RomBlock;
import com.xinyou.game.resource.Bitmap;
import com.xinyou.game.resource.GameFrame;
import com.xinyou.game.resource.GameSrs;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2021/12/26 12:54 下午
 * @history: 1.2021/12/26 created by jianfeng.zheng
 */
public class SrsReader extends ResourceReader<GameSrs> {

    public SrsReader(byte[] rom, RomBlock block, GameContext context) {
        super(rom, block, context);
    }

    @Override
    public GameSrs read() {
        int offset = this.block.getOffset();
        int index = rom[offset + 1] & 0xFF;
        int frameCount = rom[offset + 2] & 0xFF;
        int imageCount = rom[offset + 3] & 0xFF;
        int startFrame = rom[offset + 4] & 0xFF;
        int endFrame = rom[offset + 5] & 0xFF;
        offset = offset + 6;
        GameSrs srs = new GameSrs();
        srs.setFrameCount(frameCount);
        srs.setImageCount(imageCount);
        srs.setStartFrame(startFrame);
        srs.setEndFrame(endFrame);
        srs.setResourceIndex(index);
        for (int i = 0; i < frameCount; ++i) {
            GameFrame frame = new GameFrame();
            frame.setX(rom[offset++] & 0xFF);
            frame.setY(rom[offset++] & 0xFF);
            frame.setShow(rom[offset++] & 0xFF);
            frame.setnShow(rom[offset++] & 0xFF);
            frame.setImageIndex(rom[offset++] & 0xFF);
            srs.addFrame(frame);
        }
        List<Bitmap> images = new ArrayList<>();
        for (int i = 0; i < imageCount; ++i) {
            ImageReader reader = new ImageReader(rom, offset);
            Bitmap bitmap = reader.readImages().get(0);
            images.add(bitmap);
            offset += reader.getByteCount();
        }
        for (int i = 0; i < srs.getFrames().size(); ++i) {
            GameFrame frame = srs.getFrames().get(i);
            frame.setImage(images.get(frame.getImageIndex()));
        }
        return srs;
    }
}
