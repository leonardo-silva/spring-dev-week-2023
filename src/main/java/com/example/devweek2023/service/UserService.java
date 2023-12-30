package com.example.devweek2023.service;

import com.example.devweek2023.domain.model.User;

public interface UserService {
    User findById(Long id);
    User create(User userToCreate);
}
