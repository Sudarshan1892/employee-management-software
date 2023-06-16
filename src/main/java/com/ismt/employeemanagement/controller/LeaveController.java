package com.ismt.employeemanagement.controller;

import com.ismt.employeemanagement.dao.LeaveRepo;
import com.ismt.employeemanagement.entity.Leave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("leave")
public class LeaveController {
    @Autowired
    private LeaveRepo leaveRepo;

    @GetMapping("/list")
    public String ShowProducts(Model model){
        List<Leave> leaveList= leaveRepo.findAll();
        model.addAttribute("leaveList",leaveList);
        return "leave/list";
    }
    @GetMapping("/save-form")
    public String ShowSaveForm(Model model){
        Leave leave= new Leave();
        model.addAttribute("leave",leave);
        return "leave/save-form";
    }
    @GetMapping("/update-form")
    public String updateProduct(@RequestParam("id") int id, Model model){
        Optional<Leave> leave = leaveRepo.findById(id);
        model.addAttribute("leave",leave);
        return "leave/save-form";
    }
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("leave") @Valid Leave leave,
                               BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "leave/save-form";
        }else{
            leaveRepo.save(leave);
            return "redirect:/leave/save-form?success";
        }
    }
    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("id") int id){
        leaveRepo.deleteById(id);
        return "redirect:/leave/list?deletionSuccess";
    }
}
