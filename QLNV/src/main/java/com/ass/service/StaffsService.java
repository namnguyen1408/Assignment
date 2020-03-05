package com.ass.service;

import com.ass.model.Depart;
import com.ass.model.Staffs;

import java.util.Optional;

public interface StaffsService {
    Iterable<Staffs> findAll();

    Optional<Staffs> findById(Long id);

    void save(Staffs staffs);

    void remove(Long id);

  //  Iterable<Staffs> findAllByDepart(Depart depart);

}
