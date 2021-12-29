package com.xinyou.game.bbk.resource;

import com.xinyou.game.GameContext;
import com.xinyou.game.bbk.Constant;
import com.xinyou.game.bbk.RomBlock;
import com.xinyou.game.command.Command;
import com.xinyou.game.command.CommandFactory;
import com.xinyou.game.resource.GameScript;
import com.xinyou.game.resource.SceneEvent;
import com.xinyou.game.util.GameUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2021/12/29 11:08 上午
 * @history: 1.2021/12/29 created by jianfeng.zheng
 */
public class ScriptReader extends ResourceReader<GameScript> {


    public ScriptReader(byte[] rom, RomBlock block, GameContext context) {
        super(rom, block, context);
    }

    @Override
    public GameScript read() {
        int offset = this.block.getOffset();
        int type = this.readByteInt(offset);
        int resourceIndex = this.readByteInt(offset + 1);
        String description = this.readString(offset + 2);
        int length = this.readInt2(offset + 0x18);
        int gutEventCount = this.readByteInt(offset + 0x1a);
        int[] gutEvents = new int[gutEventCount];
        int eventStart = offset + 0x1b;
        for (int i = 0; i < gutEventCount; i++) {
            gutEvents[i] = this.readInt2(eventStart + (i * 2));
        }
        //length占2个字节，gutEventCount占1个字节
        int dataOffset = gutEventCount * 2 + 2 + 1;
        int start = offset + 0x18 + dataOffset;
        int end = length - dataOffset + start;
        GameScript script = new GameScript();
        script.setDescription(description);
        Map<Integer, Integer> commandMap = new HashMap<>();
        System.out.println("===============>" + type + "-" + resourceIndex);
        while (start < end) {
            int commandIndex = GameUtil.readByteInt(rom, start);
            Command command = CommandFactory.buildCommand(commandIndex);
            if (command != null) {
                command.setAddress(start - offset - 0x18);
                commandMap.put(command.getAddress(), script.getCommands().size());
                command.build(this.rom, start);
                start = start + command.getLength();
                script.addCommand(command);
                System.out.println(command.commandString());
            } else {
                break;
            }
        }
        //设置事件
        for (int i = 0; i < gutEvents.length; ++i) {
            int eventId = gutEvents[i];
            if (eventId != 0) {
                Integer commandIndex = commandMap.get(eventId);
                if (commandIndex != null) {
                    String eventType = i > Constant.MAX_NPC_EVENT ? SceneEvent.EVENT_MAP : SceneEvent.EVENT_NPC;
                    //i+1方便事件索引
                    script.addEvent(eventType, i + 1, commandIndex);
                } else {
                   // System.err.println("找不到事件:" + eventId);
                }
            }
        }
        return script;
    }
}
