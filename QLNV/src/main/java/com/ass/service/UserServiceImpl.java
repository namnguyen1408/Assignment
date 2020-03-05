package com.ass.service;

import com.ass.model.Users;
import com.ass.responsitory.UserResponsitory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserResponsitory userResponsitory;


    @Override
    public Iterable<Users> findAll() {
        return userResponsitory.findAll();
    }

    @Override
    public Optional<Users> findById(Long id) {
        return userResponsitory.findById(id);
    }

    @Override
    public void save(Users user) {
           userResponsitory.save(user);
    }

    @Override
    public void remove(Long id) {
         userResponsitory.deleteById(id);
    }



}
