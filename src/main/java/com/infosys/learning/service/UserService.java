package com.infosys.learning.service;

import com.infosys.learning.model.User;
import com.infosys.learning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(int id){
        return userRepository.getOne(id);
    }
}
