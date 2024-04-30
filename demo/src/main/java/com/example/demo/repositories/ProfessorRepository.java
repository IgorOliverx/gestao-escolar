package com.example.demo.repositories;

import com.example.demo.Model.Professor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@org.springframework.stereotype.Repository
public interface ProfessorRepository extends org.springframework.data.jpa.repository.JpaRepository<Professor, Long> {
    Professor findByEmail(String username);

    @Query("SELECT a FROM Admin a WHERE a.role = 'PROF'")
    List<Professor> findAllProf();

}
