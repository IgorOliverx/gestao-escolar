package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import com.example.demo.Model.Aluno;
import com.example.demo.dto.AlunoDto;
import com.example.demo.repositories.AlunoRepository;
import com.example.demo.Model.Aluno;

/**
 * Para entender essa classe, é preciso que você pense na AlunoService APENAS como uma interface abstrata
 * Nela, eu defino/crio os métodos CRUD ou ademais e somente aqui, eu registro a lógico de como/o que quero salvar, entende?
 * Lá = métodos abstratos
 * aqui = métodos com regras de négocio
 * PORQUE? SOLID
 * letra D = principio da inversão de dependência
 * letra S = princípio da responsabilidade única
 * mlk nessa aqui o pai foi gênio para um caralho!
 * mas ta mal feito ainda, O CERTO SERIA UMA PRA ALUNO/PROF/ADMIN
*/
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

//SE EU TIVESSE MAIS OPERAÇÕES NA CLASSE DE SERVIÇO, ENTÃO EU IMPLEMENTARIA AQUI COM SUAS REGRAS DE NEGÓCIO


}
