package com.example.demo.controller;

import com.example.demo.Model.Aluno;
import com.example.demo.Model.Professor;
import com.example.demo.dto.AdminDto;
import com.example.demo.dto.AlunoDto;
import com.example.demo.dto.ProfessorDto;
import com.example.demo.repositories.AdminRepository;
import com.example.demo.repositories.AlunoRepository;
import com.example.demo.repositories.ProfessorRepository;
import com.example.demo.service.AdminService;
import com.example.demo.service.AlunoService;

import java.security.Principal;
import java.util.List;

import com.example.demo.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/*
 * Essa classe está como UserController mas na verdade é um Controller geral, isso ficou um pouco pela preguiça
 */
@Controller
public class AlunoController {

    /*
     * Instância de classes para injeção de dependências
     */
    @Autowired
    UserDetailsService userDetailsService; // Representa os serviços que um usuário que quer se autenticar precisa
                                           // (loabByUsername)

    @Autowired
    private AlunoService alunoService; // Representa os serviços do aluno(entidade principal)
    // OBS: note que o programa deveria modularizar a classe aluno na
    // entidade(interface) USUÁRIO e depois criar elementos filhos dessa
    // interface(admin, prof e aluno)

    @Autowired
    private AdminService adminService;

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    /*
     * Mapeamento de Rotas
     */

    @GetMapping("/registration-admin")
    public String getRegistrationPageAdmin(@ModelAttribute("admin") AdminDto adminDto) {
        return "register_admin";

    }

    @PostMapping("/registration-admin")
    public String saveUserAdmin(@ModelAttribute("admin") AdminDto adminDto, Model model) {
        adminService.save(adminDto);
        model.addAttribute("message", "Register successfully!");
        return "register_admin";
    }

    @GetMapping("/registration-aluno")
    public String getRegistrationPageAluno(@ModelAttribute("aluno") AlunoDto alunoDto) {
        return "register";
    }

    @PostMapping("/registration-aluno")
    public String saveUserAluno(@ModelAttribute("aluno") AlunoDto alunoDto, Model model) {
        alunoDto.setRole("ALUNO");
        alunoService.save(alunoDto);
        model.addAttribute("message", "Register successfully!");
        return "register";
    }

    @GetMapping("/registration-professor")
    public String getRegistrationPageProfessor(@ModelAttribute("professor") ProfessorDto professorDto) {
        return "register_professor";

    }

    @PostMapping("/registration-professor")
    public String saveUserProfessor(@ModelAttribute("professor") ProfessorDto professorDto, Model model) {
        professorDto.setRole("PROF");
        professorService.save(professorDto);
        model.addAttribute("message", "Cadastro concluído com sucesso");
        return "register_professor";
    }

    @GetMapping("/")
    public String index() {
        List<com.example.demo.Model.Admin> adminList = adminRepository.findByCpf("admin");
        if (adminList.isEmpty()) {
            AdminDto adminMaster = new AdminDto("admin", "admin", "admin", "admin@admin.com", "admin", "ADMIN");
            adminService.save(adminMaster);
        }
        return "/index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /*
     * Observe que o mapeamento das rotas de login são features do Spring
     * Security(UserDetailsService)
     */
    @GetMapping("aluno-page")
    public String alunoPage(Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        return "aluno-page";
    }

    @GetMapping("admin-page")
    public String adminPage(Model model, Principal principal, @ModelAttribute("aluno") AlunoDto alunoDto) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());

        List<Professor> professoresMobile = professorRepository.listByCursoMobileProf();
        List<Professor> professoresBack = professorRepository.listByCursoBackProf();
        List<Professor> professoresUXUI = professorRepository.listByCursoUXUIProf();
        List<Professor> professoresDataAnalyst = professorRepository.listByCursoDataAnalystProf();
        List<Professor> professoresDataScientist = professorRepository.listByCursoDataScientistProf();
        List<Professor> professoresSoftware = professorRepository.listByCursoSoftwareProf();

        model.addAttribute("professoresMobile", professoresMobile);
        model.addAttribute("professoresBack", professoresBack);
        model.addAttribute("professoresUXUI", professoresUXUI);
        model.addAttribute("professoresDataAnalyst", professoresDataAnalyst);
        model.addAttribute("professoresDataScientist", professoresDataScientist);
        model.addAttribute("professoresSoftware", professoresSoftware);

        model.addAttribute("admin", userDetails);
        return "admin-page";
    }

    @GetMapping("admin-alunos--page")
    public String mostrarAlunos(Model model) {
        List<Aluno> alunos = alunoRepository.findAllAlunos();
        model.addAttribute("alunos", alunos);
        return "admin-alunos--page";
    }

    @PostMapping("admin-page")
    public String saveUserByAdmin(@ModelAttribute("aluno") AlunoDto alunoDto, Model model) {
        alunoService.save(alunoDto);
        model.addAttribute("message", "Register successfully!");
        return "register";
    }

    @GetMapping("/delete/alunos/{id}")
    public String deleteAluno(@PathVariable Long id) {
        alunoRepository.deleteById(id);
        return "redirect:/"; 
    }
    
    @GetMapping("/delete/professores/{id}")
    public String deleteProfessor(@PathVariable Long id) {
        professorRepository.deleteById(id);
        return "redirect:/"; 
    }

    @GetMapping("prof-page")
    public String profPage(Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());

        List<Aluno> alunosTodos = alunoRepository.findAllAlunos();
        List<Aluno> alunosMobile = alunoRepository.listByCursoMobile();
        List<Aluno> alunosBack = alunoRepository.listByCursoBack();
        List<Aluno> alunosUXUI = alunoRepository.listByCursoUXUI();
        List<Aluno> alunosDataAnalyst = alunoRepository.listByCursoDataAnalyst();
        List<Aluno> alunosDataScientist = alunoRepository.listByCursoDataScientist();
        List<Aluno> alunosSoftware = alunoRepository.listByCursoSoftware();

        model.addAttribute("prof", userDetails);
        model.addAttribute("alunosTodos", alunosTodos);
        model.addAttribute("alunosMobile", alunosMobile);
        model.addAttribute("alunosBack", alunosBack);
        model.addAttribute("alunosUXUI", alunosUXUI);
        model.addAttribute("alunosDataAnalyst", alunosDataAnalyst);
        model.addAttribute("alunosDataScientist", alunosDataScientist);
        model.addAttribute("alunosSoftware", alunosSoftware);
        return "prof-page";
    }
}
