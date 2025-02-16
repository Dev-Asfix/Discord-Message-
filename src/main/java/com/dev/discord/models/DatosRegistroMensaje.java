package com.dev.discord.models;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroMensaje(
        @NotBlank(message = "El mensaje no puede estar vacio")
         String text,

        @NotNull(message = "La fecha no puede ser nulla")
        @Future(message = "La fecha debe ser en el futuro")
        LocalDateTime scheduledDate
) {
}
