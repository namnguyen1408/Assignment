package com.ass.service;

import com.ass.model.Depart;
import com.ass.responsitory.DepartResponsitory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class DepartServiceImpl implements DepartService{
    @Autowired
    private DepartResponsitory departResponsitory;

    @Override
    public Iterable<Depart> findAll() {
        return  departResponsitory.findAll();
    }

    @Override
    public Optional<Depart> findById(Long id) {
        return departResponsitory.findById(id);
    }

    @Override
    public void save(Depart depart) {
        departResponsitory.save(depart);
    }

    @Override
    public void remove(Long id) {
        departResponsitory.deleteById(id);
    }
}
