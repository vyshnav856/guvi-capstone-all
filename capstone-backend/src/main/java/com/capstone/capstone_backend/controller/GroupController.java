package com.capstone.capstone_backend.controller;

import com.capstone.capstone_backend.model.Group;
import com.capstone.capstone_backend.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/groups")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @PostMapping
    public ResponseEntity<Object> createGroup(@RequestBody Group group) {
        Group newGroup = groupService.createGroup(group);
        return ResponseEntity.ok(Objects.requireNonNullElse(newGroup, false));
    }

    @GetMapping
    public ResponseEntity<List<Group>> getAllGroups() {
        List<Group> groups = groupService.getAllGroups();
        return ResponseEntity.ok(groups);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Group>> getGroupById(@PathVariable String id) {
        Optional<Group> group =  groupService.getGroupById(id);

        if (group.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        else {
            return ResponseEntity.ok(group);
        }
    }
}
