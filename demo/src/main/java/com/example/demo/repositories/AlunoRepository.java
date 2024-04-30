package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.example.demo.Model.Aluno;

/**
 * Repositório de Aluno
 */
@org.springframework.stereotype.Repository
public interface AlunoRepository extends org.springframework.data.jpa.repository.JpaRepository<Aluno, Long> {
    Aluno findByEmail(String username);

    @Query("SELECT a FROM Aluno a WHERE a.role = 'ALUNO'")
    List<Aluno> findAllAlunos();
}
