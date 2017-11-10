package com.kenkosushi.Undav.controller;

import com.kenkosushi.Undav.domain.model.User;
import com.kenkosushi.Undav.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by leo on 11/10/17.
 */

@RestController
public class UserController {

    private UserService userService;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserController(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/users/")
    public void addUser(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.save(user);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        ResponseEntity<User> response;
        User user = userService.findById(id);

        if(user != null){
            response = new ResponseEntity<User>(user, HttpStatus.OK);
        }else{
            response = new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
        }

        return response;
    }

    @GetMapping("/users/")
    public Collection<User> getAllUsers(){
        return userService.findAll();
    }
}
