package com.ismt.employeemanagement.dao;

import com.ismt.employeemanagement.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepo extends JpaRepository<Salary,Integer> {
}
