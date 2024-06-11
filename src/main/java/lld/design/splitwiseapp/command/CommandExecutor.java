package lld.design.splitwiseapp.command;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CommandExecutor {
    // Command Manager which stores and calls teh appropriate command
    List<Command> commands;
    SettleUpGroupCommand settleUpGroupCommand;

    public CommandExecutor(SettleUpGroupCommand settleUpGroupCommand){
        this.settleUpGroupCommand = settleUpGroupCommand;
        commands = new ArrayList<>();
        commands.add(this.settleUpGroupCommand);
    }

    public void addCommand(Command command){
        commands.add(command);
    }

    public void removeCommand(Command command){
        commands.remove(command);
    }

    public void execute(String input){
        for(Command command : commands){
            if(command.matches(input)){
                command.execute(input);
                return;
            }
        }
        throw new RuntimeException("Command not found!");
    }
}
