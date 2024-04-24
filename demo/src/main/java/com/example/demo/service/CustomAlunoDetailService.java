package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Aluno;
import com.example.demo.repositories.AlunoRepository;

@Service
public class CustomAlunoDetailService implements UserDetailsService{

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Aluno aluno = alunoRepository.findByEmail(username);
        if(aluno == null){
            throw new UsernameNotFoundException("Aluno not found");
        }
        return new CustomAlunoDetail(aluno);
        
        
    }
    
}
