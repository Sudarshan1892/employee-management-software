package com.ismt.employeemanagement.dao;

import com.ismt.employeemanagement.entity.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacancyRepo extends JpaRepository<Vacancy,Integer> {

}

