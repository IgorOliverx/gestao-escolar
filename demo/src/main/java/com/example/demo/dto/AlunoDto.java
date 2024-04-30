package com.example.demo.dto;

import lombok.*;

import java.beans.ConstructorProperties;

/*
 * Essa classe DTO permite encapsular(mais pra frente) a
 * entidade Aluno, em um objeto simples de manipular para o spring
 * pense que ao invés de mexer no objeto, ele manipula uma cópia
 * "data transfer object" -> meu Model pode ter mais atributos, mas aqui, ficam somente aqueles que quero transferir, no caso cadastrar no banco de dados
 */
@Getter
@Setter
@AllArgsConstructor
public class AlunoDto {

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
}
