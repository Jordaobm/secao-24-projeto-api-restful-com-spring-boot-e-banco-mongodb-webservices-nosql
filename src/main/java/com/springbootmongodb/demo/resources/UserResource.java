package com.springbootmongodb.demo.resources;

import com.springbootmongodb.demo.dtos.UserDTO;
import com.springbootmongodb.demo.entities.User;
import com.springbootmongodb.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> usersDTO = userService.findAll();
        return ResponseEntity.ok().body(usersDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        UserDTO userDTO = userService.findById(id);
        return ResponseEntity.ok().body(userDTO);
    }

    @PostMapping()
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO user) {
        UserDTO newUser = userService.create(user);
        return ResponseEntity.ok().body(newUser);
    }
}
