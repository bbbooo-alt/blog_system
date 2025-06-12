package com.example.demo.service;

import com.example.demo.model.DTO.UpdateRequest;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    Optional<User> findById(Long id);

    List<User> findAll();

    User save(User user);

    User update(Long id, UpdateRequest user);

    void deleteById(Long id);
}
