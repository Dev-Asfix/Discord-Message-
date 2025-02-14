package com.dev.discord.scheduler;

import com.dev.discord.models.Message;
import com.dev.discord.repository.MessageRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageScheduler {
    private final MessageRepository messageRepository;

    public MessageScheduler(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    //Para mayor precision ***   @Scheduled(cron = "0 * * * * *")
    //@Scheduled(fixedRate = 60000)
    @Scheduled(cron = "0 * * * * *")
    public void sendScheduledMessages(){
        LocalDateTime now = LocalDateTime.now();
        List<Message> messagesToSend = messageRepository.findByScheduledDateBefore(now);

        System.out.println("⏰ Verificando mensajes programados para: " + now);

        if(messagesToSend.isEmpty()){
            System.out.println("✅ No hay mensajes para enviar en este momento.");
        } else {
            for(Message message : messagesToSend){
                System.out.println("✅ Enviando mensaje programado: " + message.getText() + " a las " + message.getScheduledDate());
                messageRepository.delete(message);
            }
        }
    }

}
