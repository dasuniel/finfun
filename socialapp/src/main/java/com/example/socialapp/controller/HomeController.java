package com.example.socialapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        // Puedes añadir atributos al modelo si deseas mostrar datos en la vista
        model.addAttribute("message", "¡Bienvenido a SocialApp!");
        return "index";  // Asegúrate de tener una plantilla llamada "index.html" en src/main/resources/templates
    }
}
