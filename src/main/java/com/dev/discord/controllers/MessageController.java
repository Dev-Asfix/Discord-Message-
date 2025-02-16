package com.dev.discord.controllers;

import com.dev.discord.models.DatosListaMensajes;
import com.dev.discord.models.DatosRegistroMensaje;
import com.dev.discord.models.Message;
import com.dev.discord.repository.MessageRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> createMessage(@Valid @RequestBody DatosRegistroMensaje messagedto){

        boolean exists = messageRepository.existsByTextAndScheduledDate(messagedto.text(), messagedto.scheduledDate());
        if(exists){
            return ResponseEntity.badRequest().body("Ya existe un mensaje programado con este contenido y fecha.");
        }

        Message message = new Message(messagedto);
        Message savedMessage = messageRepository.save(message);
        System.out.println("📌 Mensaje guardado: " + savedMessage.getText() + " a las " + savedMessage.getScheduledDate());

        return ResponseEntity.ok(savedMessage);
    }

    //Obtener la lista de mensajes programados
    @GetMapping
    public List<DatosListaMensajes> getAllMessages(){
        return messageRepository.findAll()
                .stream()
                .map(DatosListaMensajes::new)
                .toList();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMessage(@PathVariable Long id){
        if(!messageRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mensaje no encontrado");
        }
        messageRepository.deleteById(id);
        return ResponseEntity.ok("Mensaje elimiado correctamente.");
    }
}
