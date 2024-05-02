package com.example.demo.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import lombok.*;

/*
 * Os modelos (Models) representam a estrutura de dados da aplicação, definindo os objetos que serão manipulados e armazenados no banco de dados.
 * Eles encapsulam os dados e o comportamento associado a esses dados, fornecendo uma representação abstrata das entidades do mundo real.
 */

@jakarta.persistence.Entity
@Table(name = "admin", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Getter
@Setter
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String telefone;
    private String cpf;
    private String email;
    private String senha;
    private String role;

    public Admin() {
        super();
    }

    public Admin(String nome, String telefone, String email, String senha, String role, String cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.role = role;
        this.cpf = cpf;
    }
}
