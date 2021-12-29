package com.xinyou.game.bbk.resource;

import com.xinyou.game.GameContext;
import com.xinyou.game.bbk.RomBlock;
import com.xinyou.game.util.GameUtil;

import java.io.UnsupportedEncodingException;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2021/12/25 3:24 下午
 * @history: 1.2021/12/25 created by jianfeng.zheng
 */
public abstract class ResourceReader<T> {

    protected byte[] rom;
    protected RomBlock block;
    protected GameContext context;

    public ResourceReader(byte[] rom, RomBlock block, GameContext context) {
        this.rom = rom;
        this.block = block;
        this.context = context;
    }

    /**
     * 读取2个字节int值
     *
     * @param start
     * @return
     */
    protected int readByteInt(int start) {
        return GameUtil.readByteInt(this.rom, start);
    }

    /**
     * 读取2个字节int值
     *
     * @param start
     * @return
     */
    protected int readInt2(int start) {
        return GameUtil.readInt2(this.rom, start);
    }

    /**
     * 读取4个字节int值
     *
     * @param start
     * @return
     */
    protected int readInt4(int start) {
        return GameUtil.readInt4(this.rom, start);
    }

    /**
     * 读取字符串
     *
     * @param offset
     * @return
     */
    protected String readString(int offset) {
        return GameUtil.readString(this.rom, offset);
    }

    public abstract T read();
}
