package com.example.demo.service;

import com.example.demo.Model.Admin;
import com.example.demo.Model.Aluno;
import com.example.demo.Model.Professor;
import com.example.demo.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.AlunoRepository;
import com.example.demo.repositories.AdminRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Aluno aluno = alunoRepository.findByEmail(username);
        if (aluno != null) {
            return new CustomAlunoDetail(aluno);
        }

        Admin admin = adminRepository.findByEmail(username);
        if (admin != null) {
            return new CustomAdminDetail(admin);
        }

        Professor professor = professorRepository.findByEmail(username);
        if (professor != null) {
            return new CustomProfessorDetail(professor);
        }

        throw new UsernameNotFoundException("Usuário não encontrado: " + username);
    }
}
