package com.springbootmongodb.demo.resources;

import com.springbootmongodb.demo.entities.User;
import com.springbootmongodb.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok().body(users);
    }

    @PostMapping()
    public ResponseEntity<User> create(@RequestBody User user) {
        User newUser = userService.create(user);
        return ResponseEntity.ok().body(newUser);
    }
}
