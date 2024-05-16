package com.springbootmongodb.demo.config;

import com.springbootmongodb.demo.dtos.AuthorDTO;
import com.springbootmongodb.demo.dtos.CommentDTO;
import com.springbootmongodb.demo.entities.Post;
import com.springbootmongodb.demo.entities.User;
import com.springbootmongodb.demo.repositories.PostRepository;
import com.springbootmongodb.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private PostRepository postRepository;


    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User j1 = new User(null, "John Doe 1", "johndoe1@example.com");
        User j2 = new User(null, "John Doe 2", "johndoe2@example.com");
        User j3 = new User(null, "John Doe 3", "johndoe3@example.com");

        userRepository.saveAll(Arrays.asList(j1, j2, j3));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        Post p1 = new Post(null, simpleDateFormat.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para São Paulo", new AuthorDTO(j1));
        Post p2 = new Post(null, simpleDateFormat.parse("21/03/2018"), "Bom dia", "Bom dia", new AuthorDTO(j1));

        CommentDTO c1 = new CommentDTO("Boa", simpleDateFormat.parse("21/03/2018"), new AuthorDTO(j1));
        CommentDTO c2 = new CommentDTO("Oloco", simpleDateFormat.parse("21/03/2018"), new AuthorDTO(j1));
        CommentDTO c3 = new CommentDTO("Vai não tio", simpleDateFormat.parse("21/03/2018"), new AuthorDTO(j1));


        p1.getComments().add(c1);
        p1.getComments().add(c2);
        p1.getComments().add(c3);

        postRepository.saveAll(Arrays.asList(p1, p2));

        j1.getPosts().add(p1);
        j1.getPosts().add(p2);

        userRepository.saveAll(Arrays.asList(j1, j2, j3));

    }
}
