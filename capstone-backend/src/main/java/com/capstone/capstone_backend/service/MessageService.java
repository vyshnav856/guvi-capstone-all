package com.capstone.capstone_backend.service;

import com.capstone.capstone_backend.model.Message;
import com.capstone.capstone_backend.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Optional<Message> getMessageById(String id) {
        return messageRepository.findById(id);
    }
}
