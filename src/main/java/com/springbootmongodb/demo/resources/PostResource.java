package com.springbootmongodb.demo.resources;

import com.springbootmongodb.demo.entities.Post;
import com.springbootmongodb.demo.resources.util.URL;
import com.springbootmongodb.demo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam String text) {
        String txt = URL.decodeParam(text);
        List<Post> posts = postService.findByTitle(txt);
        return ResponseEntity.ok().body(posts);
    }
}
