package com.dev.discord.repository;

import com.dev.discord.models.Message;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByScheduledDateBefore(LocalDateTime now);

    boolean existsByTextAndScheduledDate(@NotBlank(message = "El mensaje no puede estar vacio") String text, @NotNull(message = "La fecha no puede ser nulla") @Future(message = "La fecha debe ser en el futuro") LocalDateTime localDateTime);
}
