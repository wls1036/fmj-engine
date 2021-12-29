package com.xinyou.game.exception;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2021/12/25 11:15 上午
 * @history: 1.2021/12/25 created by jianfeng.zheng
 */
public class LoadException extends RuntimeException {

    public LoadException(Throwable ex) {
        ex.printStackTrace();
    }
}
