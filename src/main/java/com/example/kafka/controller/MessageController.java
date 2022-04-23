package com.example.kafka.controller;

import com.example.kafka.model.Message;
import com.example.kafka.service.producer.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {
    private final ProducerService service;

    @PostMapping("/")
    public Message sendMessage(@RequestParam String key, @RequestBody Message message) {
        service.sendMessage(key, message);
        return message;
    }

    @PostMapping("/1")
    public Message sendMessageOne(@RequestParam String key, @RequestBody Message message) {
        service.sendMessageOne(key, message);
        return message;
    }

    @PostMapping("/2")
    public Message sendMessageTwo(@RequestParam String key, @RequestBody Message message) {
        service.sendMessageTwo(key, message);
        return message;
    }
}
