package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Aluno;
import com.example.demo.repositories.AlunoRepository;

/**
 * Aqui, a classe que implementa o serviço 
*/
@Service
public class CustomAlunoDetailService implements UserDetailsService{

    //injeção de dependedencia
    @Autowired
    private AlunoRepository alunoRepository;

    //esse método procura um usuario com o nome passado no formulario de login
    //essa classe, a principio tem este método, mas não desconsidere, ele é crucial!!!1
    //essa simples verificação de nulo, evita erros de tipo, usuario logar com sua conta depois "sair"(mas continua autenticado com as sessões http) e entrar na conta de outro usuário, já que o mesmo ainda está logado no sistema
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Aluno aluno = alunoRepository.findByEmail(username);
        if(aluno == null){
            throw new UsernameNotFoundException("Aluno Não encontrado");
        }
        return new CustomAlunoDetail(aluno);
        
        
    }
    
}
