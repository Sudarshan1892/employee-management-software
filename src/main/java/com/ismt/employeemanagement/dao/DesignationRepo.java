package com.ismt.employeemanagement.dao;

import com.ismt.employeemanagement.entity.Designation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignationRepo extends JpaRepository<Designation,Integer> {
}
