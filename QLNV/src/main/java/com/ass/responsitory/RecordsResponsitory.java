package com.ass.responsitory;

import com.ass.model.Records;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RecordsResponsitory extends PagingAndSortingRepository<Records, Long> {
}
