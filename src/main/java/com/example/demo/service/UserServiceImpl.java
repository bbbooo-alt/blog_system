package com.example.demo.service;

import com.example.demo.exception.customizedException.UserNotFoundException;
import com.example.demo.model.DTO.UpdateRequest;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, UpdateRequest user) {
        User originalUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("用户不存在"));
        originalUser.setEmail(user.getEmail());
        originalUser.setName(user.getName());
        return userRepository.save(originalUser);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
