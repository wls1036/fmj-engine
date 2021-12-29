package com.xinyou.game.command;

import com.xinyou.game.GameContext;
import com.xinyou.game.util.GameUtil;


/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2021/12/29 11:05 上午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public abstract class Command {
    /**
     * 指令名称
     */
    protected String name;

    /**
     * 指令索引
     */
    protected int commandIndex;

    /**
     * 指令长度
     */
    protected int length;

    /**
     * 指定地址，方便寻址指令
     */
    protected int address;

    /**
     * 执行命令
     *
     * @param gameContext
     */
    abstract public void execute(GameContext gameContext);

    /**
     * 构建命令
     *
     * @param data
     */
    abstract public void build(byte[] data, int start);

    /**
     * 命令字符串
     *
     * @return
     */
    abstract public String commandString();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCommandIndex() {
        return commandIndex;
    }

    public void setCommandIndex(int commandIndex) {
        this.commandIndex = commandIndex;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }


    /**
     * 读取字符串
     *
     * @param data   字节数组
     * @param offset
     * @return
     */
    protected String readString(byte[] data, int offset) {
        return GameUtil.readString(data, offset);
    }

    /**
     * 计算字符串占字节数
     *
     * @param data
     * @param offset
     * @return
     */
    protected int stringBytes(byte[] data, int offset) {
        return GameUtil.stringBytes(data, offset);
    }

    /**
     * 读取2个字节int值
     *
     * @param data
     * @param start
     * @return
     */
    protected int readByteInt(byte[] data, int start) {
        return GameUtil.readByteInt(data, start);
    }

    /**
     * 读取2个字节int值
     *
     * @param data
     * @param start
     * @return
     */
    protected int readInt2(byte[] data, int start) {
        return GameUtil.readInt2(data, start);
    }

    /**
     * 读取4个字节int值
     *
     * @param data
     * @param start
     * @return
     */
    protected int readInt4(byte[] data, int start) {
        return GameUtil.readInt4(data, start);
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }
}
