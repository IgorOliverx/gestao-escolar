package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import com.example.demo.Model.Aluno;
import com.example.demo.dto.AlunoDto;
import com.example.demo.repositories.AlunoRepository;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private org.springframework.security.crypto.password.PasswordEncoder passwordEncoder;

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Aluno save(AlunoDto alunoDto) {
        Aluno aluno = new Aluno(alunoDto.getNome(), alunoDto.getTelefone(), alunoDto.getCpf(), alunoDto.getCurso(), alunoDto.getEmail(), passwordEncoder.encode(alunoDto.getSenha()), alunoDto.getNota(), alunoDto.getFalta(), alunoDto.getProfessor(), alunoDto.getHorario(), alunoDto.getRole());
        return alunoRepository.save(aluno);
    }

    

//SE EU TIVESSE MAIS OPERAÇÕES NA CLASSE DE SERVIÇO, ENTÃO EU IMPLEMENTARIA AQUI COM SUAS REGRAS DE NEGÓCIO


}
