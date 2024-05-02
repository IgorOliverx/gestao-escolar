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
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * Essa classe está como UserController mas na verdade é um Controller geral, isso ficou um pouco pela preguiça
 */
@Controller
public class UsersController {
    /*
     * Instância de classes para injeção de dependências
     */
    @Autowired
    UserDetailsService userDetailsService; // Representa os serviços que um usuário que quer se autenticar precisa
    // (loadByUsername)

    @Autowired
    private AlunoService alunoService; // Serviços relacionados ao aluno

    @Autowired
    private AdminService adminService; // Serviços relacionados ao administrador

    @Autowired
    private ProfessorService professorService; // Serviços relacionados ao professor

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    /*
     * Mapeamento de Rotas
     */

    // Rota para exibir a página de registro do administrador
    @GetMapping("/registration-admin")
    public String getRegistrationPageAdmin(@ModelAttribute("admin") AdminDto adminDto) {
        return "register_admin";
    }

    // Rota para salvar um novo administrador
    @PostMapping("/registration-admin")
    public String saveUserAdmin(@ModelAttribute("admin") AdminDto adminDto, Model model) {
        adminService.save(adminDto);
        model.addAttribute("message", "Cadastro Concluído com sucesso!");
        return "register_admin";
    }

    // Rota para exibir a página de registro do aluno
    @GetMapping("/registration-aluno")
    public String getRegistrationPageAluno(@ModelAttribute("aluno") AlunoDto alunoDto) {
        return "register";
    }

    // Rota para salvar um novo aluno
    @PostMapping("/registration-aluno")
    public String saveUserAluno(@ModelAttribute("aluno") AlunoDto alunoDto, Model model) {
        alunoDto.setRole("ALUNO");
        alunoService.save(alunoDto);
        model.addAttribute("message", "Cadastro Concluído com sucesso!");
        return "/";
    }

    // Rota para exibir a página de registro do professor
    @GetMapping("/registration-professor")
    public String getRegistrationPageProfessor(@ModelAttribute("professor") ProfessorDto professorDto) {
        return "register_professor";
    }

    // Rota para salvar um novo professor
    @PostMapping("/registration-professor")
    public String saveUserProfessor(@ModelAttribute("professor") ProfessorDto professorDto, Model model) {
        professorDto.setRole("PROF");
        professorService.save(professorDto);
        model.addAttribute("message", "Cadastro concluído com sucesso");
        return "register_professor";
    }

    // Rota inicial
    // Rota inicial
    @GetMapping("/")
    public String index() {
        List<com.example.demo.Model.Admin> adminList = adminRepository.findByCpf("admin");
        if (adminList.isEmpty()) {
            AdminDto adminMaster = new AdminDto("admin", "admin", "admin", "admin@admin.com", "admin", "ADMIN");
            adminService.save(adminMaster);
        }
        return "/index";
    }

    // Rota para exibir a página de login
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Rota para exibir a página do aluno
    @GetMapping("aluno-page")
    public String alunoPage(Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());

        model.addAttribute("user", userDetails);
        return "aluno-page";
    }

    // Rota para exibir as informações do aluno
    @GetMapping("/aluno-info")
    public String showAlunoInfo(Model model, Principal principal) {
        // Obtendo o email do aluno logado
        String email = principal.getName();

        // Buscando o aluno pelo email
        Aluno aluno = alunoRepository.findByEmail(email);

        // Verificando se o aluno foi encontrado
        if (aluno == null) {
            return "error-page";
        }

        // Adicionando o aluno ao modelo para exibição na página
        model.addAttribute("aluno", aluno);

        // Retornando a página de informações do aluno
        return "aluno-info";
    }

    // Rota para atualizar as faltas do aluno
    @PostMapping("/update-faltas")
    public ResponseEntity<String> updateFaltas(@RequestParam String email, @RequestParam String faltas) {
        Aluno aluno = alunoRepository.findByEmail(email);

        // Verifica se o aluno existe
        if (aluno != null) {
            // Atualiza a quantidade de faltas
            aluno.setFalta(faltas);

            // Salva as mudanças no banco de dados
            alunoRepository.save(aluno);

            // Retorna uma resposta de sucesso
            return ResponseEntity.ok("Faltas do aluno atualizadas com sucesso.");
        } else {
            // Se o aluno não for encontrado, retorna uma resposta de erro
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado com o email fornecido.");
        }
    }

    // Rota para exibir a página do administrador
    @GetMapping("admin-page")
    public String adminPage(Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());

        // Listando professores por curso
        List<Professor> professoresMobile = professorRepository.listByCursoMobileProf();
        List<Professor> professoresBack = professorRepository.listByCursoBackProf();
        List<Professor> professoresUXUI = professorRepository.listByCursoUXUIProf();
        List<Professor> professoresDataAnalyst = professorRepository.listByCursoDataAnalystProf();
        List<Professor> professoresDataScientist = professorRepository.listByCursoDataScientistProf();
        List<Professor> professoresSoftware = professorRepository.listByCursoSoftwareProf();

        // Adicionando professores ao modelo
        model.addAttribute("professoresMobile", professoresMobile);
        model.addAttribute("professoresBack", professoresBack);
        model.addAttribute("professoresUXUI", professoresUXUI);
        model.addAttribute("professoresDataAnalyst", professoresDataAnalyst);
        model.addAttribute("professoresDataScientist", professoresDataScientist);
        model.addAttribute("professoresSoftware", professoresSoftware);

        model.addAttribute("admin", userDetails);
        return "admin-page";
    }

    // Rota para exibir a página de alunos do administrador
    @GetMapping("admin-alunos--page")
    public String mostrarAlunos(Model model) {
        List<Aluno> alunos = alunoRepository.findAllAlunos();
        model.addAttribute("alunos", alunos);
        return "admin-alunos--page";
    }

    // Rota para salvar um novo aluno pelo administrador
    @PostMapping("admin-page")
    public String saveUserByAdmin(@ModelAttribute("aluno") AlunoDto alunoDto, Model model) {
        alunoDto.setRole("ALUNO");
        alunoService.save(alunoDto);
        model.addAttribute("message", "Cadastro Concluído com sucesso!");
        return "/";
    }

    // Rota para deletar um aluno
    @GetMapping("/delete/alunos/{id}")
    public String deleteAluno(@PathVariable Long id) {
        alunoRepository.deleteById(id);
        return "redirect:/";
    }

    // Rota para deletar um professor
    @GetMapping("/delete/professores/{id}")
    public String deleteProfessor(@PathVariable Long id) {
        professorRepository.deleteById(id);
        return "redirect:/";
    }

    // Rota para exibir a página do professor
    @GetMapping("prof-page")
    public String profPage(Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());

        // Listando alunos por curso
        List<Aluno> alunosTodos = alunoRepository.findAllAlunos();
        List<Aluno> alunosMobile = alunoRepository.listByCursoMobile();
        List<Aluno> alunosBack = alunoRepository.listByCursoBack();
        List<Aluno> alunosUXUI = alunoRepository.listByCursoUXUI();
        List<Aluno> alunosDataAnalyst = alunoRepository.listByCursoDataAnalyst();
        List<Aluno> alunosDataScientist = alunoRepository.listByCursoDataScientist();
        List<Aluno> alunosSoftware = alunoRepository.listByCursoSoftware();

        // Adicionando alunos ao modelo
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
