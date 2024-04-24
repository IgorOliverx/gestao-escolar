package com.example.demo.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.Model.Aluno;

public class CustomAlunoDetail implements UserDetails{

    private Aluno aluno;


    public CustomAlunoDetail (Aluno aluno){
        this.aluno = aluno;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       
        return List.of(() -> aluno.getRole());
    }

    public String getNome(){
        return aluno.getNome();
    }

    public String getTelefone(){
        return aluno.getTelefone();
    }

    public String getCpf(){
        return aluno.getCpf();
    }

    public String getCurso(){
        return aluno.getCurso();
    }

    @Override
    public String getPassword() {
       return aluno.getSenha();
    }

    @Override
    public String getUsername() {
       return aluno.getEmail();
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
