package com.chatbot.whatsapp_chatbot.service;

import com.chatbot.whatsapp_chatbot.model.WhatsappMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ChatbotService {
    public String processMessage(WhatsappMessage msg){
        log.info("Incoming message from {}:{}",msg.getFrom(),msg.getMessage());


        String text = msg.getMessage().trim().toLowerCase();

        String reply = switch (text){
            case "hi","hello" -> "Hello!";
            case "bye","goodbye" -> "Goodbye!";
            case  "help" -> "Available commands: Hi, Bye, Help";
            default -> "Sorry, I didn't understand that. Type 'Help' for available commands.";
        };

        log.info("Reply sent to {}: {}", msg.getFrom(),reply);
        return reply;
    }
}
