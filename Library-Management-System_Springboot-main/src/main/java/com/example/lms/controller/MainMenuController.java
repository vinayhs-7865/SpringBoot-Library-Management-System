package com.example.lms.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainMenuController {
    @GetMapping("/mainMenu")
    public String mainMenu(){
        return "mainMenu";
    }
}
