package com.springbootmongodb.demo.services;

import com.springbootmongodb.demo.entities.User;
import com.springbootmongodb.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(User user) {
        User newUser = new User();

        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());

        userRepository.save(newUser);
        return newUser;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

}
