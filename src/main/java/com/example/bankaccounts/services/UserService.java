package com.example.bankaccounts.services;

import com.example.bankaccounts.dto.CreateUserRequest;
import com.example.bankaccounts.dto.UserResponse;
import com.example.bankaccounts.entities.User;
import com.example.bankaccounts.mappers.UserMapper;
import com.example.bankaccounts.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse create(CreateUserRequest request) {
        User user = new User(request.getName(), request.getEmail(), request.getPhone());
        userRepository.save(user);
        return UserMapper.map(user);
    }

    public UserResponse getUser(long userId) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        return UserMapper.map(user);
    }

}
