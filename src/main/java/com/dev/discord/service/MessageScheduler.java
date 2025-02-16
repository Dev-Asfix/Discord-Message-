package com.dev.discord.service;

import com.dev.discord.models.Message;
import com.dev.discord.repository.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class MessageScheduler {
    private final MessageRepository messageRepository;
    private final DiscordService discordService;

    public MessageScheduler(MessageRepository messageRepository, DiscordService discordService) {
        this.messageRepository = messageRepository;
        this.discordService = discordService;
    }
    //Para mayor precision ***   @Scheduled(cron = "0 * * * * *")
    //@Scheduled(fixedRate = 60000)
    @Scheduled(cron = "0 * * * * *")
    @Transactional
    public void sendScheduledMessages(){
        LocalDateTime now = LocalDateTime.now();
        List<Message> messagesToSend = messageRepository.findByScheduledDateBefore(now);

        log.info("⏰ Verificando mensajes programados para: {}", now);


        if(messagesToSend.isEmpty()){
            //System.out.println("✅ No hay mensajes para enviar en este momento.");
            log.info("✅ No hay mensajes para enviar en este momento.");
        } else {
            for(Message message : messagesToSend){

                //System.out.println("✅ Enviando mensaje programado: " + message.getText() + " a las " + message.getScheduledDate());
                log.info("✅ Enviando mensaje programado: '{}' a las {}", message.getText(), message.getScheduledDate());

                discordService.sendMessage(message.getText());
                messageRepository.delete(message);
            }
        }
    }

}
