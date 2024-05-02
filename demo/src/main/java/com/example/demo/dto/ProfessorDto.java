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
public class ProfessorDto {

    private String nome; // Nome do professor

    private String telefone; // Número de telefone do professor

    private String cpf; // CPF do professor

    private String email; // Endereço de e-mail do professor

    private String lecionandoCurso; // Curso que o professor está lecionando

    private String senha; // Senha do professor

    private String role; // Papel ou função do professor (por exemplo, "PROF")
}
