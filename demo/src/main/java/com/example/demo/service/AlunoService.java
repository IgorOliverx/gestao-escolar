package com.example.demo.service;

import com.example.demo.Model.Aluno;
import com.example.demo.dto.AlunoDto;

/**
 * Essa interface é responsável por definir os contratos e operações
 * Interface de Serviços do aluno
 * Ela que é responsável por encapsular a classe dto em um objeto simples
 * que posteriormente será tratado pelo spring
*/
public interface AlunoService {
    
    Aluno save(AlunoDto alunoDto);
}
