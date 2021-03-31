package com.example.testfinal.repository;

import com.example.testfinal.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepository  extends PagingAndSortingRepository<City, Long> {

    //Tìm kiếm sản phẩm theo tên
    @Query(value = "select * from city where city.name like ?", nativeQuery = true)
    Page<City> findCitiesByName(String name, Pageable pageable);

}
