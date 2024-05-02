package com.example.demo.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

/*
 * Os modelos (Models) representam a estrutura de dados da aplicação, definindo os objetos que serão manipulados e armazenados no banco de dados.
 * Eles encapsulam os dados e o comportamento associado a esses dados, fornecendo uma representação abstrata das entidades do mundo real.
 */

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

    private String nota;

    private String falta;

    private String professor;

    private String horario;

    private String role;


    public Aluno() {
        super();
    }

    public Aluno(String nome, String telefone, String cpf, String curso, String email, String senha, String nota, String falta, String professor, String horario, String role) {

        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.curso = curso;
        this.email = email;
        this.senha = senha;
        this.nota = nota;
        this.falta = falta;
        this.professor = professor;
        this.horario = horario;
        this.role = role;
    }


}

