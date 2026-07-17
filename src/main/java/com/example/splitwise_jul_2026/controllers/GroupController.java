package com.example.splitwise_jul_2026.controllers;

import com.example.splitwise_jul_2026.exceptions.GroupNotFoundException;
import com.example.splitwise_jul_2026.exceptions.UnauthorizedException;
import com.example.splitwise_jul_2026.exceptions.UserNotFoundException;
import com.example.splitwise_jul_2026.models.Group;
import com.example.splitwise_jul_2026.models.User;
import com.example.splitwise_jul_2026.services.GroupService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GroupController {
    private GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    public Group createGroup(Long adminId, String groupName) throws UserNotFoundException {
        return groupService.createGroup(groupName, adminId);
    }
}

/*

Register -> UserController
SettleUp -> SettleUpController

 */
