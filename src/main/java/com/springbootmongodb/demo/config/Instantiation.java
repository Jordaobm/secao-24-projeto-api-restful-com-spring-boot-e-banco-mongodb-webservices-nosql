package com.springbootmongodb.demo.config;

import com.springbootmongodb.demo.entities.User;
import com.springbootmongodb.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User j1 = new User(null, "John Doe 1", "johndoe1@example.com");
        User j2 = new User(null, "John Doe 2", "johndoe2@example.com");
        User j3 = new User(null, "John Doe 3", "johndoe3@example.com");

        userRepository.saveAll(Arrays.asList(j1, j2, j3));


    }
}
