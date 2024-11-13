package com.example.socialapp.controller;

import com.example.socialapp.model.Post;
import com.example.socialapp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/new-post")
    public String showPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "newPost";
    }

    @PostMapping("/new-post")
    public String submitPost(@ModelAttribute("post") Post post) {
        post.setTimestamp(LocalDateTime.now());
        postRepository.save(post);
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String viewPosts(Model model) {
        model.addAttribute("posts", postRepository.findAll());
        return "home";
    }
}
