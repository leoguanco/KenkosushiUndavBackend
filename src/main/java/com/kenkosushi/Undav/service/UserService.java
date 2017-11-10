package com.kenkosushi.Undav.service;

import com.kenkosushi.Undav.domain.model.User;
import com.kenkosushi.Undav.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public User findById(Long id){
        return userRepository.findOne(id);
    }
}
