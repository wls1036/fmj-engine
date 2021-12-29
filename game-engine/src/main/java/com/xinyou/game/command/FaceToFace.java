package com.xinyou.game.command;

import com.xinyou.game.GameContext;

/**
 * @Description: FACETOFACE n m
 * 角色n与角色m面相对，0为主角
 * @author: jianfeng.zheng
 * @since: 2021/12/29 9:17 下午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public class FaceToFace extends Command {

    //角色1 0为主角
    private int player1;

    //角色2 0为主角
    private int player2;

    @Override
    public void execute(GameContext gameContext) {

    }

    @Override
    public void build(byte[] data, int start) {
        this.name = "面对面";
        this.commandIndex = this.readByteInt(data, start);
        this.player1 = this.readInt2(data, start + 1);
        this.player1 = this.readInt2(data, start + 3);
        this.length = 5;
    }

    @Override
    public String commandString() {
        return String.format("FACETOFACE %d %d", player1, player2);
    }
}
