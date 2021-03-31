package com.example.testfinal.service.nation;

import com.example.testfinal.model.Nation;
import com.example.testfinal.repository.INationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationService implements INationService {

    @Autowired
    private INationRepository nationRepository;

    @Override
    public List<Nation> findAll() {
        return (List<Nation>) nationRepository.findAll();
    }

    @Override
    public Page<Nation> findAll(Pageable pageable) {
        return nationRepository.findAll(pageable);
    }

    @Override
    public Nation findById(Long id) {
        return nationRepository.findById(id).get();
    }

    @Override
    public Nation save(Nation nation) {
        return nationRepository.save(nation);
    }

    @Override
    public void remove(Long id) {
        nationRepository.deleteById(id);
    }
}
