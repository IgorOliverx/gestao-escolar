package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import com.example.demo.Model.Aluno;

/*
 * Os repositórios (Repositories) são componentes responsáveis por fornecer uma interface para interagir com o banco de dados.
 * Eles encapsulam a lógica de acesso aos dados, abstraindo detalhes de implementação do acesso aos dados do resto da aplicação.
 * Aqui estão algumas finalidades gerais dos repositórios:
 */

@org.springframework.stereotype.Repository
public interface AlunoRepository extends org.springframework.data.jpa.repository.JpaRepository<Aluno, Long> {
    Aluno findByEmail(String username);

    @Query("SELECT a FROM Aluno a WHERE a.role = 'ALUNO'")
    List<Aluno> findAllAlunos();

    @Query("SELECT a FROM Aluno a WHERE a.curso = 'Dev. Mobile'")
    List<Aluno> listByCursoMobile();

    @Query("SELECT a FROM Aluno a WHERE a.curso = 'Dev. Back-end'")
    List<Aluno> listByCursoBack();

    @Query("SELECT a FROM Aluno a WHERE a.curso = 'UX/UI Design'")
    List<Aluno> listByCursoUXUI();

    @Query("SELECT a FROM Aluno a WHERE a.curso = 'Dev. Software'")
    List<Aluno> listByCursoSoftware();

    @Query("SELECT a FROM Aluno a WHERE a.curso = 'Cientista de dados'")
    List<Aluno> listByCursoDataScientist();

    @Query("SELECT a FROM Aluno a WHERE a.curso = 'Analista de Dados'")
    List<Aluno> listByCursoDataAnalyst();

}
