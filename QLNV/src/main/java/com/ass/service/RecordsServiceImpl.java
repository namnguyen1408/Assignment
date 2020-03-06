package com.ass.service;

import com.ass.model.Records;
import com.ass.responsitory.RecordsResponsitory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class RecordsServiceImpl implements RecordService{
    @Autowired
    private RecordsResponsitory recordResponsitory;
    @Override
    public Iterable<Records> findAll() {
        return recordResponsitory.findAll();
    }

    @Override
    public Optional<Records> findById(Long id) {
        return recordResponsitory.findById(id);
    }

    @Override
    public void save(Records records) {
        recordResponsitory.save(records);
    }

    @Override
    public void remove(Long id) {
        recordResponsitory.deleteById(id);
    }
}
