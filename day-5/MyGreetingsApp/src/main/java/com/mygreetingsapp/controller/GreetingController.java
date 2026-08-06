package com.mygreetingsapp.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("message",
                "Welcome to My Greetings App");

        return "welcome";
    }

    @GetMapping("/greet")
    public String greet(Model model) {

        model.addAttribute("name", "Lovely");

        return "greeting";
    }

}