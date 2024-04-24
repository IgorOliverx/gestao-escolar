package com.example.demo.repositories;

import com.example.demo.Model.Aluno;

@org.springframework.stereotype.Repository
public interface AlunoRepository extends org.springframework.data.jpa.repository.JpaRepository<Aluno, Long>{
    Aluno findByEmail (String email);
}
