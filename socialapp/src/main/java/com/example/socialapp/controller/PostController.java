// PostController.java
package com.example.socialapp.controller;

import com.example.socialapp.model.Post;
import com.example.socialapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/new-post")
    public String showPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "new-post";
    }

    @PostMapping("/new-post")
    public String createPost(@ModelAttribute("post") Post post) {
        postService.savePost(post);
        return "redirect:/home"; // Redirige a la página de inicio después de publicar
    }
}

