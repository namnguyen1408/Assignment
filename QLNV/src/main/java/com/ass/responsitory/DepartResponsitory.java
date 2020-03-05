package com.ass.responsitory;

import com.ass.model.Depart;
import com.ass.model.Staffs;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DepartResponsitory extends PagingAndSortingRepository<Depart, Long> {
}
