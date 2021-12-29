package com.xinyou.game.resource;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2021/12/27 9:15 下午
 * @history: 1.2021/12/27 created by jianfeng.zheng
 */
public class GameFrame {

    //x坐标
    private int x;

    //y坐标
    private int y;

    //
    private int show;

    private int nShow;

    private int imageIndex;

    private Bitmap image;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getShow() {
        return show;
    }

    public void setShow(int show) {
        this.show = show;
    }

    public int getnShow() {
        return nShow;
    }

    public void setnShow(int nShow) {
        this.nShow = nShow;
    }

    public int getImageIndex() {
        return imageIndex;
    }

    public void setImageIndex(int imageIndex) {
        this.imageIndex = imageIndex;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
