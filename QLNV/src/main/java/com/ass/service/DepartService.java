package com.ass.service;

import com.ass.model.Depart;


import java.util.Optional;

public interface DepartService {
    Iterable<Depart> findAll();

    Optional<Depart> findById(Long id);

    void save(Depart depart);

    void remove(Long id);
}
