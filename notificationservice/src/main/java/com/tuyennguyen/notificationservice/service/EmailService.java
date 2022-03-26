package com.tuyennguyen.notificationservice.service;

import com.tuyennguyen.notificationservice.model.MessageDTO;

public interface EmailService {

    void sendEmail(MessageDTO messageDTO);

}
