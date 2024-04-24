package com.example.demo.controller;


import com.example.demo.dto.AlunoDto;
import com.example.demo.service.AlunoService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AlunoController {
    
    @Autowired
    private AlunoService alunoService;

    

    @GetMapping("/registration")
    public String getRegistrationPage(@ModelAttribute("aluno") AlunoDto alunoDto){
        return "register";
    }

    @PostMapping("/registration")
    public String saveUser(@ModelAttribute("aluno") AlunoDto alunoDto, Model model){
        alunoService.save(alunoDto);
        model.addAttribute("message", "Register successfully!");
        return "register";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
