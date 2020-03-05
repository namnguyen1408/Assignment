package com.ass.service;

import com.ass.model.Depart;
import com.ass.model.Staffs;
import com.ass.responsitory.StaffsResponsitory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class StaffsServiceImpl implements StaffsService{

    @Autowired //giúp gọi đối tượng customerrepository đx đc khai báo @Bean trên applicationConfig
    private StaffsResponsitory staffsResponsitory;
    @Override
    public Iterable<Staffs> findAll() {
        return  staffsResponsitory.findAll();
    }

    @Override
    public Optional<Staffs> findById(Long id) {
        return staffsResponsitory.findById(id);
    }

    @Override
    public void save(Staffs staffs) {
        staffsResponsitory.save(staffs);
    }

    @Override
    public void remove(Long id) {
        staffsResponsitory.deleteById(id);
    }

//    @Override
//    public Iterable<Staffs> findAllByDepart(Depart depart) {
//        return staffsResponsitory.findAllByDepart(depart);
//    }




}
