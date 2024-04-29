package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlunoDto {

    private String nome;
    private String telefone;
    private String cpf;
    private String curso;
    private String email;
    private String senha;
    private String role;

    public AlunoDto(String nome, String telefone, String cpf, String curso, String email, String senha, String role) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.curso = curso;
        this.email = email;
        this.senha = senha;
        this.role = role;
    }
}
