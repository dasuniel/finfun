package com.example.socialapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")  // Activa el perfil "test" para simplificar el contexto
class SocialappApplicationTests {

    @Test
    void contextLoads() {
    }
}

