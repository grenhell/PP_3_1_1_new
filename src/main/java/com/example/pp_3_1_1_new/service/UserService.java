package com.example.pp_3_1_1_new.service;

import com.example.pp_3_1_1_new.model.User;
import com.example.pp_3_1_1_new.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save (User user){
        return userRepository.save(user);
    }

    public User findById (Long id){
        return userRepository.findById(id).orElse(null);
    }
    public List<User> findAll (){
        return userRepository.findAll();
    }
    public void delete (Long id){
        userRepository.deleteById(id);
    }



}
