package com.ismt.employeemanagement.dao;

import com.ismt.employeemanagement.entity.User;

import java.util.List;

public interface UserRepo {
    List<User> getAllUser();

    User getUserById(int id);

    void save(User user);

    User findUserByEmail(String email);

    void delete(int id);
}
