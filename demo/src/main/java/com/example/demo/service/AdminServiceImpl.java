package com.example.demo.service;

import com.example.demo.Model.Admin;
import com.example.demo.dto.AdminDto;
import com.example.demo.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private org.springframework.security.crypto.password.PasswordEncoder passwordEncoder;

    @Autowired
    AdminRepository adminRepository;

    public Admin save(AdminDto adminDto) {
        Admin admin = new Admin(adminDto.getNome(), adminDto.getTelefone(), adminDto.getEmail(), passwordEncoder.encode(adminDto.getSenha()), adminDto.getRole(), adminDto.getCpf());
        return adminRepository.save(admin);
    }


}
