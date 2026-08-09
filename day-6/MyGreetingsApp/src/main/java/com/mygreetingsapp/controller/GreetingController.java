package com.mygreetingsapp.controller;

import com.mygreetingsapp.model.Greeting;
import com.mygreetingsapp.service.GreetingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/greetings")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping
    public String listGreetings(Model model) {
        model.addAttribute("greetings", greetingService.findAll());
        model.addAttribute("greeting", new Greeting());
        return "greetings/list";
    }

    @PostMapping
    public String createGreeting(@ModelAttribute Greeting greeting) {
        greetingService.save(greeting);
        return "redirect:/greetings";
    }

    @GetMapping("/{id}")
    public String showGreeting(@PathVariable Long id, Model model) {
        Greeting greeting = greetingService.findById(id);
        if (greeting == null) {
            return "redirect:/greetings";
        }
        model.addAttribute("greeting", greeting);
        return "greetings/show";
    }

    @PostMapping("/{id}/delete")
    public String deleteGreeting(@PathVariable Long id) {
        greetingService.delete(id);
        return "redirect:/greetings";
    }
}
