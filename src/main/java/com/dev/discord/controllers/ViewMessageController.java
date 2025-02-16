package com.dev.discord.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewMessageController {

    @GetMapping("/home")
    public String showPage(){
        return "messages";
    }
}
