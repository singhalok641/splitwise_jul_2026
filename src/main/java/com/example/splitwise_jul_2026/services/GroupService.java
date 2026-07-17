package com.example.splitwise_jul_2026.services;


import com.example.splitwise_jul_2026.exceptions.GroupNotFoundException;
import com.example.splitwise_jul_2026.exceptions.UnauthorizedException;
import com.example.splitwise_jul_2026.exceptions.UserNotFoundException;
import com.example.splitwise_jul_2026.models.Group;
import com.example.splitwise_jul_2026.models.User;
import com.example.splitwise_jul_2026.repositories.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    private final UserService userService;
    private final GroupRepository groupRepository;

    public GroupService(UserService userService,
                        GroupRepository groupRepository) {
        this.userService = userService;
        this.groupRepository = groupRepository;
    }

    public Group createGroup(String groupName, Long adminUserId) throws UserNotFoundException {
        User admin = userService.getUserById(adminUserId);

        Group group = new Group();
        group.setName(groupName);
        group.setAdmin(admin);
        group.getMembers().add(admin); // ["rishav"]
        group.setCreatedAt(new Date());
        group.setLastModifiedAt(new Date());

        return groupRepository.save(group);
    }

    public Group addMember(Long memberUserId, Long groupId, Long adminUserId) throws GroupNotFoundException, UnauthorizedException, UserNotFoundException {
        Group group = getGroupById(groupId);

        // only admins can add members
        if (!group.getAdmin().getId().equals(adminUserId)) {
            throw new UnauthorizedException("Only the group admin can add members");
        }

        User newMember = userService.getUserById(memberUserId);

        // Don't add duplicates
        boolean alreadyMember = group.getMembers().stream()
                .anyMatch(m -> m.getId().equals(memberUserId));

        if (!alreadyMember) {
            group.getMembers().add(newMember);
            group.setLastModifiedAt(new Date());
            groupRepository.save(group);
        }
        return group;
    }

    public Group getGroupById(Long groupId) throws GroupNotFoundException {
        return groupRepository.findById(groupId)
                .orElseThrow(() -> new GroupNotFoundException(
                        "Group with id:" + groupId + " not found"
                ));
    }
}
