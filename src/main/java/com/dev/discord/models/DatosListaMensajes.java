package com.dev.discord.models;

import java.time.LocalDateTime;

public record DatosListaMensajes(

         Long id,
        String text,
        LocalDateTime scheduledDate
) {
    public DatosListaMensajes(Message message){
        this(message.getId(), message.getText(), message.getScheduledDate());
    }
}
