package com.ismt.employeemanagement.controller;

import com.ismt.employeemanagement.dao.VacancyRepo;
import com.ismt.employeemanagement.entity.Vacancy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("vacancy")
public class VacancyController {
    @Autowired
    private VacancyRepo vacancyRepo;

    @GetMapping("/list")
    public String ShowUnits(Model model){
        List<Vacancy> vacancyList= vacancyRepo.findAll();
        model.addAttribute("vacancyList",vacancyList);
        return "vacancy/list";
    }

    @GetMapping("/save-form")
    public String ShowSaveForm(Model model){
        Vacancy vacancy= new Vacancy();
        model.addAttribute("vacancy",vacancy);
        return "vacancy/save-form";
    }

    @GetMapping("/update-form")
    public String updateUnit(@RequestParam("id") int id, Model model){
        Optional<Vacancy> vacancy = vacancyRepo.findById(id);
        model.addAttribute("vacancy",vacancy);
        return "vacancy/save-form";
    }
    @PostMapping("/save")
    public String saveUnit(@ModelAttribute("vacancy") @Valid Vacancy vacancy,
                               BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "vacancy/save-form";
        }else{
            vacancyRepo.save(vacancy);
            return "redirect:/vacancy/save-form?success";
        }
    }
    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("id") int id){
        vacancyRepo.deleteById(id);
        return "redirect:/vacancy/list?deletionSuccess";
    }
}
