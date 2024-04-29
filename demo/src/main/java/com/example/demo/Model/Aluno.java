package com.example.demo.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.*;

@jakarta.persistence.Entity
@Table(name = "alunos", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Getter
@Setter
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String telefone;

    private String cpf;

    private String curso;

    private String email;

    private String senha;

    private String role;

    public Aluno() {
        super();
    }

    public Aluno(String nome, String telefone, String cpf, String curso, String email, String senha, String role) {

        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.curso = curso;
        this.email = email;
        this.senha = senha;
        this.role = role;
    }
}
