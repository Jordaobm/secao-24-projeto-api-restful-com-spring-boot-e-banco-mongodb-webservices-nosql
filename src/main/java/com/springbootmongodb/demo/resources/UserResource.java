package com.springbootmongodb.demo.resources;

import com.springbootmongodb.demo.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping()
    public ResponseEntity<List<User>> create() {
        User a = new User("1", "John Doe 1", "johndoe1@example.com");
        User b = new User("2", "John Doe 2", "johndoe2@example.com");
        List<User> list = new ArrayList<User>();
        list.addAll(Arrays.asList(a, b));
        return ResponseEntity.ok().body(list);
    }
}
