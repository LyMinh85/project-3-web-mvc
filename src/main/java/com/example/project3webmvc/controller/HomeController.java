package com.example.project3webmvc.controller;

import com.example.project3webmvc.entity.Vegetable;
import com.example.project3webmvc.repository.VegetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private VegetableRepository vegetableRepository;

    @GetMapping("/")
    public String homePage(Model model) {
        Iterable<Vegetable> vegetables = vegetableRepository.findAll();
        model.addAttribute("vegetables", vegetables);
        return "index";
    }
}
