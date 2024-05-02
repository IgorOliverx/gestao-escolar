package com.example.demo.service;

import com.example.demo.Model.Admin;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/*
 * Em uma aplicação Spring, as classes "Custom" geralmente indicam componentes personalizados que estendem ou implementam funcionalidades específicas.
 */

public class CustomAdminDetail implements UserDetails {

    private Admin admin;

    public CustomAdminDetail(Admin admin){
        this.admin = admin;
    }

    // Método responsável po mapear as roles
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(admin.getRole()));
    }

    public String getNome() {
        return admin.getNome();
    }

    public String getCpf() {
        return admin.getCpf();
    }

    public String getEmail() {
        return admin.getEmail();
    }

    public String getTelefone() {
        return admin.getTelefone();
    }

    @Override
    public String getPassword() {
        return admin.getSenha();
    }

    @Override
    public String getUsername() {
        return admin.getEmail();
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
