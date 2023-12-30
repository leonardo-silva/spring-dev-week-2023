package com.example.devweek2023.service.impl;

import com.example.devweek2023.domain.model.User;
import com.example.devweek2023.domain.repository.UserRepository;
import com.example.devweek2023.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserInterfaceImpl implements UserService {

    private final UserRepository userRepository;

    public UserInterfaceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber()))
            throw new IllegalArgumentException("This Account Number already exists!");

        return userRepository.save(userToCreate);
    }
}
