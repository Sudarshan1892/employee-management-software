

package com.ismt.employeemanagement.controller;

import com.ismt.employeemanagement.dao.DepartmentRepo;
import com.ismt.employeemanagement.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("department")
public class DepartmentController {
    @Autowired
    private DepartmentRepo departmentRepo;

     @GetMapping("/list")
    public String ShowDepartment(Model model){
        List<Department> categoryList= departmentRepo.findAll();
        model.addAttribute("departmentList",categoryList);
        return "department/list";
    }
    @GetMapping("/save-form")
    public String ShowSaveForm(Model model){
        Department department= new Department();
        model.addAttribute("department",department);
        return "department/save-form";
    }
    @GetMapping("/update-form")
    public String updateDepartment(@RequestParam("id") int id, Model model){
        Department department = departmentRepo.findById(id).get();
        model.addAttribute("department",department);
        return "department/save-form";
    }
    @PostMapping("/save")
    public String saveDepartment(@ModelAttribute("department") @Valid Department department,
                               BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "department/save-form";
        }else{
            departmentRepo.save(department);
            return "redirect:/department/save-form?success";
        }
    }
    @GetMapping("/delete")
    public String deleteDepartment(@RequestParam("id") int id){
        departmentRepo.deleteById(id);
        return "redirect:/department/list?deletionSuccess";
    }
}
