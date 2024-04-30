package com.example.demo.service;

import com.example.demo.Model.Professor;
import com.example.demo.dto.ProfessorDto;

public interface ProfessorService {

    Professor save(ProfessorDto professorDto);
}
