package com.ismt.employeemanagement.controller;

import com.ismt.employeemanagement.dao.SalaryRepo;
import com.ismt.employeemanagement.entity.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("salary")
public class SalaryController {
    @Autowired
    private SalaryRepo salaryRepo;

    @GetMapping("/list")
    public String ShowProducts(Model model){
        List<Salary> salaryList= salaryRepo.findAll();
        model.addAttribute("salaryList",salaryList);
        return "salary/list";
    }
    @GetMapping("/save-form")
    public String ShowSaveForm(Model model){
        Salary salary= new Salary();
        model.addAttribute("salary",salary);
        return "salary/save-form";
    }
    @GetMapping("/update-form")
    public String updateProduct(@RequestParam("id") int id, Model model){
        Optional<Salary> salary = salaryRepo.findById(id);
        model.addAttribute("salary",salary);
        return "salary/save-form";
    }
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("productDto") @Valid Salary salary,
                              BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "salary/save-form";
        }else{
            salaryRepo.save(salary);
            return "redirect:/salary/save-form?success";
        }
    }
    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("id") int id){
        salaryRepo.deleteById(id);
        return "redirect:/salary/list?deletionSuccess";
    }
}