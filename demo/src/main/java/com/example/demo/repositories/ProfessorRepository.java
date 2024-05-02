package com.example.demo.repositories;

import com.example.demo.Model.Professor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/*
 * Os repositórios (Repositories) são componentes responsáveis por fornecer uma interface para interagir com o banco de dados.
 * Eles encapsulam a lógica de acesso aos dados, abstraindo detalhes de implementação do acesso aos dados do resto da aplicação.
 * Aqui estão algumas finalidades gerais dos repositórios:
 */

@org.springframework.stereotype.Repository
public interface ProfessorRepository extends org.springframework.data.jpa.repository.JpaRepository<Professor, Long> {
    Professor findByEmail(String username);

    @Query("SELECT a FROM Professor a WHERE a.role = 'PROF'")
    List<Professor> findAllProf();

    @Query("SELECT a FROM Professor a WHERE a.Curso = 'Dev. Mobile'")
    List<Professor> listByCursoMobileProf();

    @Query("SELECT a FROM Professor a WHERE a.Curso = 'Dev. Back-end'")
    List<Professor> listByCursoBackProf();

    @Query("SELECT a FROM Professor a WHERE a.Curso = 'UX/UI Design'")
    List<Professor> listByCursoUXUIProf();

    @Query("SELECT a FROM Professor a WHERE a.Curso = 'Dev. Software'")
    List<Professor> listByCursoSoftwareProf();

    @Query("SELECT a FROM Professor a WHERE a.Curso = 'Cientista de dados'")
    List<Professor> listByCursoDataScientistProf();

    @Query("SELECT a FROM Professor a WHERE a.Curso = 'Analista de Dados'")
    List<Professor> listByCursoDataAnalystProf();

}
