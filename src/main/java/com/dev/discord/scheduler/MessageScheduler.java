package com.dev.discord.scheduler;

import com.dev.discord.models.Message;
import com.dev.discord.repository.MessageRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class MessageScheduler {
    private final MessageRepository messageRepository;

    public MessageScheduler(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    @Scheduled(fixedRate = 60000)
    public void sendScheduledMessages(){
        List<Message> messageToSend = messageRepository.findByScheduledDateBefore(LocalDateTime.now());

        for(Message message : messageToSend){
            System.out.println("Enviando mensaje programado: " + message.getText());
            messageRepository.delete(message);
        }
    }
}
