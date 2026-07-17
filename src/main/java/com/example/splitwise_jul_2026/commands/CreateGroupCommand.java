package com.example.splitwise_jul_2026.commands;

import com.example.splitwise_jul_2026.controllers.GroupController;
import com.example.splitwise_jul_2026.models.Group;
import org.springframework.stereotype.Component;

@Component
public class CreateGroupCommand implements Command {
    private final GroupController groupController;

    public CreateGroupCommand(GroupController groupController) {
        this.groupController = groupController;
    }

    // CreateGroup u1 <groupName>
    @Override
    public boolean matches(String input) {
        String[] words = input.split(" ");
        return words.length == 3 && words[0].equals(CommandKeywords.CREATE_GROUP);
    }

    @Override
    public void execute(String input) {
        try {
            String[] words = input.split(" ");
            Long adminId = Long.parseLong(words[1].substring(1)); // "u1" -> 1L
            String groupName = words[2];

            Group group = groupController.createGroup(adminId, groupName);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }
}
