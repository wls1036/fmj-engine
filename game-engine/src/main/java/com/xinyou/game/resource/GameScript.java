package com.xinyou.game.resource;

import com.xinyou.game.command.Command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2021/12/29 1:04 下午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public class GameScript {

    private String description;

    private Map<Integer, SceneEvent> sceneEvents = new HashMap<>();

    private List<Command> commands = new ArrayList<>();

    public List<Command> getCommands() {
        return commands;
    }

    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addEvent(String type, int eventIndex, int commandIndex) {
        SceneEvent event = new SceneEvent(type, eventIndex, commandIndex);
        sceneEvents.put(eventIndex, event);
    }
}
