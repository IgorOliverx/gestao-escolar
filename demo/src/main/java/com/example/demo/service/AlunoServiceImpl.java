package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import com.example.demo.Model.Aluno;
import com.example.demo.dto.AlunoDto;
import com.example.demo.repositories.AlunoRepository;
import com.example.demo.Model.Aluno;


@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private org.springframework.security.crypto.password.PasswordEncoder passwordEncoder;
 
    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Aluno save(AlunoDto alunoDto) {
        Aluno aluno = new Aluno(alunoDto.getNome(), alunoDto.getTelefone(), alunoDto.getCpf(), alunoDto.getCurso(), alunoDto.getEmail(), passwordEncoder.encode(alunoDto.getSenha()), alunoDto.getRole());
        return alunoRepository.save(aluno);
}



}
