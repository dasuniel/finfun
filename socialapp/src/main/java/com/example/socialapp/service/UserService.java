// UserService.java
package com.example.socialapp.service;

import com.example.socialapp.model.User;
import com.example.socialapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Método para guardar un usuario
    public void saveUser(User user) {
        userRepository.save(user);
    }
}


