package com.xinyou.game.resource;

import com.xinyou.game.exception.LoadException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2021/12/25 1:45 下午
 * @history: 1.2021/12/25 created by jianfeng.zheng
 */
public class Bitmap extends BufferedImage {


    public Bitmap(int width, int height, int[] bit) {
        super(width, height, TYPE_4BYTE_ABGR);
        this.setRGB(0, 0, width, height, bit, 0, width);
    }

    /**
     * 保存到本地
     * @param file
     */
    public void save(String file) {
        File outputfile = new File(file);
        try {
            ImageIO.write(this, "PNG", outputfile);
        } catch (IOException e) {
            e.printStackTrace();
            throw new LoadException(e);
        }
    }
}
