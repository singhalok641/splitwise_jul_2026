package com.example.splitwise_jul_2026.commands;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommandExecutor {
    private List<Command> commandList;

    // Spring will auto-inject all the Command interface implementations
    public CommandExecutor(List<Command> commandList) {
        this.commandList = commandList; // ["CreateGroup", "RegisterUser"]
    }

    public void execute(String input) {
        for (Command command: commandList) {
            if (command.matches(input)) {
                command.execute(input);
                return;
            }
        }
        System.out.println("Unknown command: " + input);
    }
}
