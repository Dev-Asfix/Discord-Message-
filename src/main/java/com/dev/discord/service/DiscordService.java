package com.dev.discord.service;

import jakarta.annotation.PostConstruct;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DiscordService {
    private JDA jda;

    @Value("${discord.bot.token}") // Usaremos application.properties para mayor seguridad
    private String botToken;

    @Value("${discord.channel.id}") // ID del canal donde se enviarán los mensajes
    private String channelId;

    @PostConstruct
    public void init() {
        try {
            jda = JDABuilder.createDefault(botToken).build().awaitReady();
            System.out.println("✅ Bot de Discord iniciado correctamente.");
        } catch (Exception e) {
            System.err.println("❌ Error al iniciar el bot de Discord: " + e.getMessage());
        }
    }

    public void sendMessage(String message) {
        TextChannel channel = jda.getTextChannelById(channelId);
        if (channel != null) {
            channel.sendMessage(message).queue();
            System.out.println("📨 Mensaje enviado a Discord: " + message);
        } else {
            System.err.println("❌ No se encontró el canal de Discord con ID: " + channelId);
        }
    }
}
