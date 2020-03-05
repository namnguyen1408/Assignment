package com.ass.responsitory;

import com.ass.model.Depart;
import com.ass.model.Staffs;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffsResponsitory extends PagingAndSortingRepository<Staffs,Long> {
//  Iterable<Staffs> findAllByDepart(Depart depart);
}
