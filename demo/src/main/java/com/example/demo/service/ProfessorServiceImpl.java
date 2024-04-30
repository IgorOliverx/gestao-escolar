package com.example.demo.service;

import com.example.demo.Model.Professor;
import com.example.demo.dto.ProfessorDto;
import com.example.demo.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorServiceImpl implements ProfessorService {
    @Autowired
    private org.springframework.security.crypto.password.PasswordEncoder passwordEncoder;

    @Autowired
    ProfessorRepository professorRepository;

    public Professor save(ProfessorDto professorDto) {
        Professor professor = new Professor(professorDto.getNome(), professorDto.getTelefone(), professorDto.getEmail(), professorDto.getLecionandoCurso(), passwordEncoder.encode(professorDto.getSenha()), professorDto.getRole(), professorDto.getCpf());
        return professorRepository.save(professor);
    }
}
