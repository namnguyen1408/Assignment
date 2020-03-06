package com.ass.service;

import com.ass.model.Records;

import java.util.Optional;

public interface RecordService  {

    Iterable<Records> findAll();
    Optional<Records> findById(Long id);
    void save(Records records);
    void remove(Long id);
}
