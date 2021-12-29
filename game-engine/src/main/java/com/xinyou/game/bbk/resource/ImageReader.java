package com.xinyou.game.bbk.resource;

import com.xinyou.game.bbk.Constant;
import com.xinyou.game.bbk.RomBlock;
import com.xinyou.game.resource.Bitmap;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2021/12/25 2:28 下午
 * @history: 1.2021/12/25 created by jianfeng.zheng
 */
public class ImageReader {

    public static final Integer IMAGE_TRANS = 2;
    public static final Integer IMAGE_NO_TRANS = 1;

    private byte[] rom;
    private RomBlock block;
    private int byteCount;

    public ImageReader(byte[] rom, int offset) {
        this.rom = rom;
        RomBlock block = new RomBlock();
        block.setOffset(offset);
        this.block = block;
    }

    public ImageReader(byte[] rom, RomBlock block) {
        this.rom = rom;
        this.block = block;
    }

    /**
     * 读取图片
     *
     * @return
     */
    public List<Bitmap> readImages() {
        List<Bitmap> bitmaps = null;
        int fileIndex = this.block.getOffset();
        int imgTrans = rom[fileIndex + 5] & 0xFF;
        if (IMAGE_TRANS == imgTrans) {
            bitmaps = this.readTransImages();
        } else {
            bitmaps = this.readNoTransImages();
        }
        return bitmaps;
    }

    /**
     * 读取透明图片
     *
     * @return
     */
    private List<Bitmap> readTransImages() {
        List<Bitmap> images = new ArrayList<>();
        int fileIndex = this.block.getOffset();
        int imgType = rom[fileIndex++] & 0xFF;
        int imgIndex = rom[fileIndex++] & 0xFF;
        int imgWidth = rom[fileIndex++] & 0xFF;
        int imgHeight = rom[fileIndex++] & 0xFF;
        int imgNumber = rom[fileIndex++] & 0xFF;
        int imgTrans = rom[fileIndex++] & 0xFF;

        this.byteCount = imgNumber * (imgWidth / 8 + (imgWidth % 8 != 0 ? 1 : 0)) * imgHeight * 2 + 6;

        for (int i = 0; i < imgNumber; ++i) {
            int[] image = new int[imgWidth * imgHeight];
            int offset = 0;
            int index = 0;
            for (int h = 0; h < imgHeight; ++h) {
                for (int w = 0; w < imgWidth; ++w) {
                    if ((rom[fileIndex] << offset & 0x80) != 0) {
                        image[index++] = Constant.COLOR_TRANSP;
                    } else {
                        image[index++] = ((rom[fileIndex] << offset << 1) & 0x80) != 0 ?
                                Constant.COLOR_BLACK : Constant.COLOR_WHITE;
                    }
                    offset += 2;
                    if (offset >= 8) {
                        offset = 0;
                        ++fileIndex;
                    }
                }
                if (offset != 0) {
                    ++fileIndex;
                    offset = 0;
                }
                if (fileIndex % 2 != 0) {
                    ++fileIndex;
                }
            }
            images.add(new Bitmap(imgWidth, imgHeight, image));
        }
        return images;
    }

    /**
     * 读取非透明图片
     *
     * @return
     */
    private List<Bitmap> readNoTransImages() {
        List<Bitmap> images = new ArrayList<>();
        int fileIndex = this.block.getOffset();
        int imgType = rom[fileIndex++] & 0xFF;
        int imgIndex = rom[fileIndex++] & 0xFF;
        int imgWidth = rom[fileIndex++] & 0xFF;
        int imgHeight = rom[fileIndex++] & 0xFF;
        int imgNumber = rom[fileIndex++] & 0xFF;
        int imgTrans = rom[fileIndex++] & 0xFF;
        this.byteCount = imgNumber * (imgWidth / 8 + (imgWidth % 8 != 0 ? 1 : 0)) * imgHeight + 6;
        for (int i = 0; i < imgNumber; ++i) {
            int[] image = new int[imgWidth * imgHeight];
            int offset = 0;
            int index = 0;
            for (int h = 0; h < imgHeight; ++h) {
                for (int w = 0; w < imgWidth; ++w) {
                    image[index++] = ((rom[fileIndex] << offset) & 0x80) != 0 ?
                            Constant.COLOR_BLACK : Constant.COLOR_WHITE;
                    offset += 1;
                    if (offset >= 8) {
                        offset = 0;
                        ++fileIndex;
                    }
                }
                if (offset != 0) {
                    ++fileIndex;
                    offset = 0;
                }
            }
            images.add(new Bitmap(imgWidth, imgHeight, image));
        }
        return images;
    }

    public int getByteCount() {
        return byteCount;
    }

    public void setByteCount(int byteCount) {
        this.byteCount = byteCount;
    }
}
