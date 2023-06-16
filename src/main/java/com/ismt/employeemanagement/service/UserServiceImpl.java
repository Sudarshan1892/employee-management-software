package com.ismt.employeemanagement.service;

import com.ismt.employeemanagement.dao.UserRepo;
import com.ismt.employeemanagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<User> getAllUser() {
        return userRepo.getAllUser();
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return userRepo.getUserById(id);
    }

    @Override
    @Transactional
    public void save(User user) {
        //encode the password being saved by user
        User securedUser=new User();
        securedUser.setName(user.getName());
        securedUser.setEmail(user.getEmail());
        securedUser.setPassword(passwordEncoder.encode(user.getPassword()));
        securedUser.setPhoneNumber(user.getPhoneNumber());
        securedUser.setDesignationId(user.getDesignationId());
        securedUser.setRole(user.getRole());
        //save the user after encoding password
        userRepo.save(securedUser);
    }

    @Override
    @Transactional
    public User findUserByEmail(String email) {
        //check the database for existing user with email.
        return userRepo.findUserByEmail(email);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=findUserByEmail(s);
        if(user == null){
            throw new UsernameNotFoundException("Invalid Email or Password");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),
        getAuthorities(user));
    }

    @Override
    @Transactional
    public void delete(int id) {
        userRepo.delete(id);
    }

    private Collection<? extends GrantedAuthority> getAuthorities(User user) {
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();

        list.add(new SimpleGrantedAuthority("Admin"));

        return list;
    }
}
