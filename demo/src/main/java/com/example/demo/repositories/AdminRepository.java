package com.example.demo.repositories;

import com.example.demo.Model.Admin;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@org.springframework.stereotype.Repository
public interface AdminRepository extends org.springframework.data.jpa.repository.JpaRepository<Admin, Long> {
    Admin findByEmail(String username);

    List<Admin> findByCpf(String cpf);

    @Query("SELECT a FROM Admin a WHERE a.role = 'ADMIN'")
    List<Admin> findAllAdmin();

}
