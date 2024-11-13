package com.example.socialapp;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;



import com.example.socialapp.repository.UserRepository;
import com.example.socialapp.service.UserDetailsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class SocialappApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Test
    void contextLoads() {
        // Verifica que el contexto de la aplicación se carga correctamente
    }

    @Test
    void userRepositoryLoads() {
        // Verifica que el repositorio de usuarios esté cargado en el contexto
        assertThat(userRepository).isNotNull();
    }

    @Test
    void userDetailsServiceLoads() {
        // Verifica que el servicio de detalles de usuario esté cargado en el contexto
        assertThat(userDetailsService).isNotNull();
    }
}
