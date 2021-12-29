package com.xinyou.game.resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2021/12/25 7:54 下午
 * @history: 1.2021/12/25 created by jianfeng.zheng
 */
public class GameTile {

    private List<Bitmap> images;

    public GameTile(List<Bitmap> images){
        this.images=images;
    }

    public List<Bitmap> getImages() {
        return images;
    }

    public void setImages(List<Bitmap> images) {
        this.images = images;
    }
}