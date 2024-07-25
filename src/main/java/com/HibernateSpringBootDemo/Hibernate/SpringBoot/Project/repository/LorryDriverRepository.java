package com.HibernateSpringBootDemo.Hibernate.SpringBoot.Project.repository;

import com.HibernateSpringBootDemo.Hibernate.SpringBoot.Project.entity.LorryDriver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LorryDriverRepository extends JpaRepository<LorryDriver, Long> {
}
