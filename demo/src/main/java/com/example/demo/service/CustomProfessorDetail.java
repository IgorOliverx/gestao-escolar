package com.example.demo.service;

import com.example.demo.Model.Admin;
import com.example.demo.Model.Professor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomProfessorDetail implements UserDetails {

    private Professor professor;

    public CustomProfessorDetail(Professor professor){
        this.professor = professor;
    }

    // Método responsável po mapear as roles
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(professor.getRole()));
    }

    public String getNome() {
        return professor.getNome();
    }

    public String getCpf() {
        return professor.getCpf();
    }

    public String getEmail() {
        return professor.getEmail();
    }

    public String getTelefone() {
        return professor.getTelefone();
    }

    public String getRole(){
        return professor.getRole();
    }

    @Override
    public String getPassword() {
        return professor.getSenha();
    }

    @Override
    public String getUsername() {
        return professor.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
