package com.example.fufastorebemongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.fufastorebemongo.dto.UserDTO;
import com.example.fufastorebemongo.model.Users;
import com.example.fufastorebemongo.repository.UserRepository;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    private UserDTO convertToDTO(Users user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId().toHexString());
        userDTO.setName(user.getName());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhone(user.getPhone());
        userDTO.setRole(user.getRole());
        return userDTO;
    }

    public List<UserDTO> getAllUsers() {
        List<Users> users = userRepository.findAll();
        return users.stream().map(this::convertToDTO).toList();
    }

}
