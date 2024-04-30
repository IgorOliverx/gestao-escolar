package com.example.demo.dto;

import lombok.*;

// Nessa classe digo o que precisarei saber para efetuar um cadastro de Admin

@Getter
@Setter
@AllArgsConstructor
public class ProfessorDto {

    private String nome;

    private String telefone;

    private String cpf;

    private String email;

    private String lecionandoCurso;

    private String senha;

    private String role;
}
