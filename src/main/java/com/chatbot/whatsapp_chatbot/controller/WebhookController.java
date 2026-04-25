package com.chatbot.whatsapp_chatbot.controller;

import com.chatbot.whatsapp_chatbot.model.WhatsappMessage;
import com.chatbot.whatsapp_chatbot.service.ChatbotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhook")
public class WebhookController {
    @Autowired
    private ChatbotService chatbotService;

    @PostMapping
    public String receiveMessage(@RequestBody WhatsappMessage msg){
        return chatbotService.processMessage(msg);
    }
}
