package com.xinyou.game.resource;

import java.util.List;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2021/12/28 2:19 下午
 * @history: 1.2021/12/28 created by jianfeng.zheng
 */
public class Bitmaps {

    private List<Bitmap> images;

    public Bitmaps(List<Bitmap> images) {
        this.images = images;
    }

    public List<Bitmap> getImages() {
        return images;
    }

    public void setImages(List<Bitmap> images) {
        this.images = images;
    }

    public void save(String path, String prefix) {
        int index = 0;
        for (Bitmap bitmap : images) {
            String name = String.format("%s/%s-%s.png", path, prefix, index++);
            bitmap.save(name);
        }
    }
}
