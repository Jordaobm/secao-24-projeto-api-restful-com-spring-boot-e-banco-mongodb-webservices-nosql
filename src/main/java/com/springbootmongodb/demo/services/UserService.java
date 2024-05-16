package com.springbootmongodb.demo.services;

import com.springbootmongodb.demo.dtos.UserDTO;
import com.springbootmongodb.demo.entities.User;
import com.springbootmongodb.demo.repositories.UserRepository;
import com.springbootmongodb.demo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        List<UserDTO> usersDTO = users.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
        return usersDTO;
    }

    public UserDTO findById(String id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        UserDTO userDTO = new UserDTO(user.get());
        return userDTO;
    }
}
