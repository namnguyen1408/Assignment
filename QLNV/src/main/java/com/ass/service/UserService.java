package com.ass.service;

import com.ass.model.Depart;
import com.ass.model.Users;

import java.util.Optional;

public interface UserService {

    Iterable<Users> findAll();

    Optional<Users> findById(Long id);

    void save(Users user);

    void remove(Long id);
}
