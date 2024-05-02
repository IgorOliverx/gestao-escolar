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
public class AdminDto {

    private String nome; // Nome do administrador

    private String telefone; // Número de telefone do administrador

    private String cpf; // CPF do administrador

    private String email; // Endereço de e-mail do administrador

    private String senha; // Senha do administrador

    private String role; // Papel ou função do administrador (por exemplo, "ADMIN")
}
