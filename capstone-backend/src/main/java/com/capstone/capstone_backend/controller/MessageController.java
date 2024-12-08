package com.capstone.capstone_backend.controller;

import com.capstone.capstone_backend.model.Message;
import com.capstone.capstone_backend.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping
    public ResponseEntity<Object> createMessage(@RequestBody Message message) {
        Message newMessage = messageService.createMessage(message);
        return ResponseEntity.ok(Objects.requireNonNullElse(newMessage, false));
    }

    @GetMapping
    public ResponseEntity<List<Message>> getAllMessages() {
        List<Message> messages = messageService.getAllMessages();
        return ResponseEntity.ok(messages);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Message>> getMessageById(@PathVariable String id) {
        Optional<Message> message =  messageService.getMessageById(id);

        if (message.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        else {
            return ResponseEntity.ok(message);
        }
    }
}
