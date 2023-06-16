package com.ismt.employeemanagement.dao;

import com.ismt.employeemanagement.entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRepo extends JpaRepository<Leave, Integer> {

}
