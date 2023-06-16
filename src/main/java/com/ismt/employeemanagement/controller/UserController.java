package com.ismt.employeemanagement.controller;

import com.ismt.employeemanagement.dao.UserRepo;
import com.ismt.employeemanagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/list")
    public String ShowUnits(Model model){
        List<User> userList= userRepo.getAllUser();
        model.addAttribute("userList",userList);
        return "user/list";
    }

    @GetMapping("/save-form")
    public String ShowSaveForm(Model model){
        User user= new User();
        model.addAttribute("user",user);
        return "user/save-form";
    }

    @GetMapping("/update-form")
    public String update(@RequestParam("id") int id, Model model){
        User user = userRepo.getUserById(id);
        model.addAttribute("user",user);
        return "user/save-form";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("user") @Valid User user,
                               BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "user/save-form";
        }else{
            userRepo.save(user);
            return "redirect:/user/save-form?success";
        }
    }
    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("id") int id){
        userRepo.delete(id);
        return "redirect:/user/list?deletionSuccess";
    }
}
