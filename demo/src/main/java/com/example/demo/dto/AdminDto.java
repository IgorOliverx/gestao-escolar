package com.example.demo.dto;

import lombok.*;

// Nessa classe digo o que precisarei saber para efetuar um cadastro de Admin

@Getter
@Setter
@AllArgsConstructor
public class AdminDto {

    private String nome;

    private String telefone;

    private String cpf;

    private String email;

    private String senha;

    private String role;
}
