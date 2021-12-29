package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description: IFCMP n m label
 * 脚标号为n变量与数m相等就跳转到脚本地址标号为label处运行
 * @author: jianfeng.zheng
 * @since: 2021/12/29 11:01 下午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public class IfCmp extends Command {

    //变量索引
    private int varIndex;

    //对比数字
    private int number;

    //相等跳转的地址
    private int gotoAddr;

    @Override
    public void execute(GameContext gameContext) {

    }

    @Override
    public void build(byte[] data, int start) {
        this.name = "是否相等";
        this.commandIndex = this.readByteInt(data, start);
        this.varIndex = this.readInt2(data, start + 1);
        this.number = this.readInt2(data, start + 3);
        this.gotoAddr = this.readInt2(data, start + 5);
        this.length = 7;
    }

    @Override
    public String commandString() {
        return String.format("IFCMP %d %d %d", varIndex, number, gotoAddr);
    }
}
