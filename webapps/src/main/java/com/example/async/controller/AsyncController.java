package com.example.async.controller;

import com.example.async.domain.EnqueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("async")
public class AsyncController {

    @Autowired
    EnqueueService enqueueService;

    @PostMapping
    public String sendMessage() {
        boolean result = enqueueService.sendQueueMessage();
        if(!result) {
            return "Fail.";
        }
        return "Complete.";
    }
}
