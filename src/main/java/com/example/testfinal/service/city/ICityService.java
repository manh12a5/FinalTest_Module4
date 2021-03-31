package com.example.testfinal.service.city;

import com.example.testfinal.model.City;
import com.example.testfinal.service.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICityService extends IService<City> {

    Page<City> findCitiesByName(String name, Pageable pageable);
}
