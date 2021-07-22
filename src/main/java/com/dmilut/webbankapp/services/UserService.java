package com.dmilut.webbankapp.services;

import com.dmilut.webbankapp.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();

    Optional<User> findById(long id);

    Optional<User> findByEmail(String email);

    User save(User user);

    void deleteById(long id);
}