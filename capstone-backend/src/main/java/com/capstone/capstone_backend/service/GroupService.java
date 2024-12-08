package com.capstone.capstone_backend.service;

import com.capstone.capstone_backend.model.Group;
import com.capstone.capstone_backend.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public Optional<Group> getGroupById(String id) {
        return groupRepository.findById(id);
    }
}
