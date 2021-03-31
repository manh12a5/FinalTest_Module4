package com.example.testfinal.repository;

import com.example.testfinal.model.Nation;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INationRepository extends PagingAndSortingRepository<Nation, Long> {
}
