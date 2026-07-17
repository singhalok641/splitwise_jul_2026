package com.example.splitwise_jul_2026.commands;

public interface Command {
    /*
    Check if the command can handle the given input
     */
    boolean matches(String input);


    /*
    Execute the command with the given input
     */
    void execute(String input);
}

/*
Command interface
Individual commands
CommandExecutor
 */
