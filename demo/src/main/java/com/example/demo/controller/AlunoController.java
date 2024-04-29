package com.example.demo.controller;


import com.example.demo.dto.AlunoDto;
import com.example.demo.service.AlunoService;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.bind.annotation.RequestParam;

/*
* Essa classe está como UserController mas na verdade é um Controller geral, isso ficou um pouco pela preguiça
*/
@Controller
public class AlunoController { 

    /*
    * Instância de classes para injeção de dependências
    */
    @Autowired
    UserDetailsService userDetailsService; //Representa os serviços que um usuário que quer se autenticar precisa (loabByUsername)
    
    
    @Autowired
    private AlunoService alunoService; //Representa os serviços do aluno(entidade principal)
    //OBS: note que o programa deveria modularizar a classe aluno na entidade(interface) USUÁRIO e depois criar elementos filhos dessa interface(admin, prof e aluno)

    
    /*
    * Mapeamento de Rotas
    */
    @GetMapping("/registration")
    public String getRegistrationPage(@ModelAttribute("aluno") AlunoDto alunoDto){
        return "register";
    }


    @PostMapping("/registration")
    public String saveUser(@ModelAttribute("aluno") AlunoDto alunoDto, Model model){
        alunoService.save(alunoDto); //Aqui o certo seria a modularização e o admin/prof/aluno ter o seu(tudo herdade de uma interface usuario -> ou classe abstrata, depende das limitações do spring (na verdade de minha capacidade intelectual e cognitiva))
        model.addAttribute("message", "Register successfully!");
        return "register";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    
    @GetMapping("/")
    public String index() {
        return "/index";
    }
    
    
    /*
    * Observe que o mapeamento das rotas de login são features do Spring Security(UserDetailsService)
    */
    @GetMapping("aluno-page")
    public String alunoPage(Model model, Principal principal){
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        return "aluno-page";
    }

    @GetMapping("admin-page")
    public String adminPage(Model model, Principal principal){
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("admin", userDetails);
        return "admin-page";
        //o Senhor aloisio boi bandido não está me ajudando como deveria, essa porra demorou para caralho para ser construída, gostaria que você tivesse me ajudado
    }

    @GetMapping("prof-page")
    public String profPage(Model model, Principal principal){
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("prof", userDetails);
        return "prof-page";
        //o Senhor aloisio boi bandido não está me ajudando como deveria, essa porra demorou para caralho para ser construída, gostaria que você tivesse me ajudado
    }
}
