package com.xinyou.game.command;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2021/12/29 1:24 下午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public class CommandFactory {

    /**
     * 脚本支持的所有指令集合
     */
    public static Map<Integer, Class<? extends Command>> commands;

    static {
        commands = new HashMap<>();
        commands.put(1, LoadMap.class);
        commands.put(2, CreateActor.class);
        commands.put(3, DeleteNpc.class);
        commands.put(6, Move.class);
        commands.put(9, Callback.class);
        commands.put(10, Goto.class);
        commands.put(11, IF.class);
        commands.put(13, Say.class);
        commands.put(14, StartChapter.class);
        commands.put(26, SetEvent.class);
        commands.put(29, FaceToFace.class);
        commands.put(30, Movie.class);
        commands.put(32, CreateBox.class);
        commands.put(33, DeleteBox.class);
        commands.put(35, InitFight.class);
        commands.put(37, FightDisable.class);
        commands.put(38, CreateNpc.class);
        commands.put(43, SetMoney.class);
        commands.put(52, DeleteAllNpc.class);
        commands.put(53, NpcStep.class);
        commands.put(54, SetSceneName.class);
        commands.put(55, ShowSceneName.class);
        commands.put(61, ShowGut.class);
    }

    /**
     * 构建命令
     *
     * @param commandIndex
     * @return
     */
    public static Command buildCommand(int commandIndex) {
        Class commandClazz = commands.get(commandIndex);
        if (commandClazz == null) {
            System.out.println("指令:" + commandIndex + "未实现");
            return null;
        }
        try {
            Command command = (Command) commandClazz.newInstance();
            return command;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
