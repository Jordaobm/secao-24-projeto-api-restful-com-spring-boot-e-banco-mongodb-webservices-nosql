package com.springbootmongodb.demo.services;

import com.springbootmongodb.demo.dtos.UserDTO;
import com.springbootmongodb.demo.entities.User;
import com.springbootmongodb.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO create(UserDTO user) {
        User newUser = new User();

        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());

        userRepository.save(newUser);

        UserDTO userDTO = new UserDTO(newUser);
        return userDTO;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

}
