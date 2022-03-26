package com.tuyennguyen.notificationservice.controller;

import com.tuyennguyen.notificationservice.model.MessageDTO;
import com.tuyennguyen.notificationservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @Autowired
    EmailService emailService;

    @PostMapping("send-notification")
    public boolean sendEmail(@RequestBody MessageDTO messageDTO) {
        emailService.sendEmail(messageDTO);
        return true;
    }

}
