package com.dev.discord.controllers;

import com.dev.discord.models.Message;
import com.dev.discord.repository.MessageRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/messages")
public class MessageController {

    private final MessageRepository messageRepository;

    public MessageController(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    //Aqui esta para guardar un mensaje programado
    @PostMapping
    public ResponseEntity<Message> createMessage(@Valid @RequestBody Message message){

        Message savedMessage = messageRepository.save(message);
        System.out.println("📌 Mensaje guardado: " + savedMessage.getText() + " a las " + savedMessage.getScheduledDate());

        return ResponseEntity.ok(savedMessage);
    }

    //Obtener la lista de mensajes programados
    @GetMapping
    public List<Message> getAllMessages(){
        return messageRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMessage(@PathVariable Long id){
        Optional<Message> message = messageRepository.findById(id);
        if(message.isPresent()){
            messageRepository.deleteById(id);
            return ResponseEntity.ok("Mensaje eliminado correctamente");
        }
        return ResponseEntity.notFound().build();
    }
}
