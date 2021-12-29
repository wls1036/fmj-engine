package com.xinyou.game.util;

import com.xinyou.game.bbk.Constant;

import java.io.UnsupportedEncodingException;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2021/12/29 1:46 下午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public class GameUtil {


    /**
     * 读取字符串
     *
     * @param data   字节数组
     * @param offset
     * @return
     */
    public static String readString(byte[] data, int offset) {
        int size = 0;
        while (data[offset + size] != 0) {
            ++size;
        }
        byte[] buf = new byte[size];
        System.arraycopy(data, offset, buf, 0, size);
        String text = null;
        try {
            text = new String(buf, Constant.DEFAULT_ENCODING);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return text;
    }

    /**
     * 计算字符串占字节数
     *
     * @param data
     * @param offset
     * @return
     */
    public static int stringBytes(byte[] data, int offset) {
        int size = 0;
        while (data[offset + size] != 0) {
            ++size;
        }
        return size;
    }

    /**
     * 读取2个字节int值
     *
     * @param data
     * @param start
     * @return
     */
    public static int readByteInt(byte[] data, int start) {
        return (int) (data[start] & 0xFF);
    }

    /**
     * 读取2个字节int值
     *
     * @param data
     * @param start
     * @return
     */
    public static int readInt2(byte[] data, int start) {
        return ((int) data[start] & 0xFF) | ((int) data[start + 1] << 8 & 0xFF00);
    }

    /**
     * 读取4个字节int值
     *
     * @param data
     * @param start
     * @return
     */
    public static int readInt4(byte[] data, int start) {
        return ((int) data[start] & 0xFF) | ((int) data[start + 1] << 8 & 0xFF00)
                | ((int) data[start + 2] << 16 & 0xFF0000) | ((int) data[start + 3] << 24);
    }
}
