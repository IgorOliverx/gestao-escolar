package com.example.demo.dto;

import lombok.*;

/*
 * DTOs (Data Transfer Objects) são utilizados para transferir dados entre componentes de um sistema.
 * Eles encapsulam dados em uma estrutura simples e serializável, facilitando a comunicação entre diferentes partes do sistema.
 * Aqui estão algumas finalidades gerais dos DTOs:
 */

@Getter
@Setter
@AllArgsConstructor
public class AlunoDto {

    private String nome; // Nome do aluno
    private String telefone; // Número de telefone do aluno
    private String cpf; // CPF do aluno
    private String curso; // Curso do aluno
    private String email; // Endereço de e-mail do aluno
    private String senha; // Senha do aluno
    private String nota; // Nota do aluno
    private String falta; // Quantidade de faltas do aluno
    private String professor; // Nome do professor do aluno
    private String horario; // Horário das aulas do aluno
    private String role; // Papel ou função do aluno (por exemplo, "ALUNO")
}
