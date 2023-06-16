package com.ismt.employeemanagement.controller;

import com.ismt.employeemanagement.dao.DesignationRepo;
import com.ismt.employeemanagement.entity.Designation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("designation")
public class DesignationController {
    @Autowired
    private DesignationRepo designationRepo;

    @GetMapping("/list")
    public String ShowCustomers(Model model){
        List<Designation> designationList= designationRepo.findAll();
        model.addAttribute("designationList",designationList);
        return "designation/list";
    }
    @GetMapping("/save-form")
    public String ShowSaveForm(Model model){
        Designation designation=new Designation();
        model.addAttribute("designation",designation);
        return "designation/save-form";
    }
    @GetMapping("/update-form")
    public String updateDesignation(@RequestParam("id") int id, Model model){
        Optional<Designation> designation = designationRepo.findById(id);
        model.addAttribute("designation",designation);
        return "designation/save-form";
    }
    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("designation") @Valid Designation designation,
                               BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "designation/save-form";
        }else{
            designationRepo.save(designation);
            return "redirect:/designation/save-form?success";
        }
    }
    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("id") int id){
        designationRepo.deleteById(id);
        return "redirect:/designation/list?deletionSuccess";
    }
}
