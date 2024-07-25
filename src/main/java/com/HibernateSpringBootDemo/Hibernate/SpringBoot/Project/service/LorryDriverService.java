package com.HibernateSpringBootDemo.Hibernate.SpringBoot.Project.service;

import com.HibernateSpringBootDemo.Hibernate.SpringBoot.Project.repository.LorryDriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.HibernateSpringBootDemo.Hibernate.SpringBoot.Project.entity.LorryDriver;

import java.util.List;
import java.util.Optional;

@Service
public class LorryDriverService {
    @Autowired
    private LorryDriverRepository repository;

    public List<LorryDriver> findAll() {
        return repository.findAll();
    }

    public Optional<LorryDriver> findById(Long id) {
        return repository.findById(id);
    }

    public LorryDriver save(LorryDriver driver) {
        return repository.save(driver);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}