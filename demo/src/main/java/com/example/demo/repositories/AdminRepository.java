package com.example.demo.repositories;

import com.example.demo.Model.Admin;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/*
 * Os repositórios (Repositories) são componentes responsáveis por fornecer uma interface para interagir com o banco de dados.
 * Eles encapsulam a lógica de acesso aos dados, abstraindo detalhes de implementação do acesso aos dados do resto da aplicação.
 * Aqui estão algumas finalidades gerais dos repositórios:
 */

@org.springframework.stereotype.Repository
public interface AdminRepository extends org.springframework.data.jpa.repository.JpaRepository<Admin, Long> {
    Admin findByEmail(String username);

    List<Admin> findByCpf(String cpf);

    @Query("SELECT a FROM Admin a WHERE a.role = 'ADMIN'")
    List<Admin> findAllAdmin();

}
