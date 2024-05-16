package com.springbootmongodb.demo.services;

import com.springbootmongodb.demo.entities.Post;
import com.springbootmongodb.demo.repositories.PostRepository;
import com.springbootmongodb.demo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;


    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isEmpty()) {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return post.get();
    }


}
