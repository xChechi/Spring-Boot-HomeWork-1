package com.example.homework1.service;

import com.example.homework1.entity.User;
import com.example.homework1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findOne (int id) {

        return userRepository.findById(id);
    }

    public void deleteUser (int id) {

        userRepository.deleteById(id);
    }

    public User createUser (User user) {

        return userRepository.save(user);
    }
}
