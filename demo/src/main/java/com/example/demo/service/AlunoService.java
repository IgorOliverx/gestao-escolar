package com.example.demo.service;

import com.example.demo.Model.Aluno;
import com.example.demo.dto.AlunoDto;

public interface AlunoService {
    
    Aluno save(AlunoDto alunoDto);
}
