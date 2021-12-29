package com.xinyou.game.resource;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2021/12/25 3:40 下午
 * @history: 1.2021/12/25 created by jianfeng.zheng
 */
public class GameMap {
    private String gameName;

    private Integer height;

    private Integer width;

    private Integer tileIndex;

    private MapBlock[] blocks;

    private GameTile tile;

    public GameMap(int width, int height) {
        this.height = height;
        this.width = width;
        blocks = new MapBlock[height * width];
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public MapBlock[] getBlocks() {
        return blocks;
    }

    public void setBlocks(MapBlock[] blocks) {
        this.blocks = blocks;
    }

    public Integer getTileIndex() {
        return tileIndex;
    }

    public void setTileIndex(Integer tileIndex) {
        this.tileIndex = tileIndex;
    }

    public void setMapBlock(int index, MapBlock block) {
        this.blocks[index] = block;
    }

    public void setMapBlock(int x, int y, MapBlock block) {
        this.blocks[y * width + x] = block;
    }

    public MapBlock getMapBlock(int x, int y) {
        return this.blocks[y * width + x];
    }

    public GameTile getTile() {
        return tile;
    }

    public void setTile(GameTile tile) {
        this.tile = tile;
    }

    public void save() {
        System.out.println(this.getGameName());
        BufferedImage img = new BufferedImage(16 * width, 16 * height, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics graphics = img.getGraphics();
        for (int h = 0; h < height; ++h) {
            for (int w = 0; w < width; ++w) {
                MapBlock block = this.getMapBlock(w, h);
                if (block.getImageIndex() >= tile.getImages().size()) {
                    System.out.println("exception==>" + this.getGameName());
                    continue;
                }
                Bitmap bitmap = tile.getImages().get(block.getImageIndex());
                graphics.drawImage(bitmap, 16 * w, 16 * h, null);
            }
        }
        graphics.dispose();
        try {
            ImageIO.write(img, "PNG", new File("/Users/asan/workspace/prod/fmj-service/map", this.getGameName() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
