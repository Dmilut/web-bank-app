package com.dmilut.webbankapp.services;

import com.dmilut.webbankapp.model.User;
import com.dmilut.webbankapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements com.dmilut.webbankapp.services.UserService {
    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        // TODO Auto-generated method stub
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(long id) {
        // TODO Auto-generated method stub
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        // TODO Auto-generated method stub
        return userRepository.findByEmail(email);
    }

    @Override
    public User save(User user) {
        // TODO Auto-generated method stub
        return userRepository.save(user);
    }

    @Override
    public void deleteById(long id) {
        // TODO Auto-generated method stub
        userRepository.deleteById(id);
    }
}