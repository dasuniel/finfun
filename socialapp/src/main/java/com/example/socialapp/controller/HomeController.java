package com.example.socialapp.controller;

import com.example.socialapp.model.Post;
import com.example.socialapp.model.User;
import com.example.socialapp.repository.PostRepository;
import com.example.socialapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postRepository.findAll());
        return "index";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password, @RequestParam String email, Model model) {
        if (userRepository.findByUsername(username).isPresent()) {
            model.addAttribute("error", "El nombre de usuario ya está en uso.");
            return "register";
        }
        // Opcional: validar también si el correo ya está registrado
        if (userRepository.findByEmail(email).isPresent()) {
            model.addAttribute("error", "El correo electrónico ya está en uso.");
            return "register";
        }
        
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setEmail(email);
        userRepository.save(user);
        return "redirect:/login";
    }

    @PostMapping("/post")
    public String post(@RequestParam String content, Principal principal, Model model) {
        try {
            // Obtener el usuario autenticado a través de su nombre de usuario
            User user = userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
            
            Post post = new Post();
            post.setContent(content);
            post.setUser(user);
            post.setTimestamp(LocalDateTime.now());
            postRepository.save(post);
        } catch (Exception e) {
            model.addAttribute("error", "Error al publicar. Por favor intenta de nuevo.");
            return "index"; // Aquí puedes redirigir de vuelta a la página con el error
        }
        return "redirect:/";
    }
}

