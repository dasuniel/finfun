package com.example.socialapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SocialappApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocialappApplication.class, args);
    }

    // Mensaje de inicio opcional
    @Bean
    CommandLineRunner init() {
        return args -> System.out.println("¡Bienvenido a SocialApp! La aplicación ha iniciado correctamente. 🚀");
    }
}

