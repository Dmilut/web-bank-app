package com.dmilut.webbankapp.controllers;

import com.dmilut.webbankapp.exceptions.RecordNotFoundException;
import com.dmilut.webbankapp.model.User;
import com.dmilut.webbankapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/users/{id}")
    public User getUserById(@PathVariable("id") @Min(1) long id) {
        User user = userService.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("User with ID : " + id + " is Not Found!"));

        return user;
    }

    @PostMapping(value = "/users")
    public User addUser(@Valid @RequestBody User user) {

        return userService.save(user);
    }

    @PutMapping(value = "/users/{id}")
    public User updateUser(@PathVariable("id") @Min(1) long id, @Valid @RequestBody User newUser) {
        User user = userService.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("User with ID : " + id + " is Not Found!"));
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setEmail(newUser.getEmail());

        return userService.save(user);
    }

    @DeleteMapping(value = "/users/{id}")
    public String deleteUser(@PathVariable("id") @Min(1) long id) {
        User user = userService.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("User with ID : " + id + " is Not Found!"));
        userService.deleteById(user.getId());

        return "User with ID :" + id + " is deleted";
    }
}