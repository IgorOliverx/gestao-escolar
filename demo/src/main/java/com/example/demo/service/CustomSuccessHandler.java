package com.example.demo.service;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Essa classe é responsável por verificar qual role é passada no cabeçalho de autorização e destinar a pagina interna certa
*/
@Service
public class CustomSuccessHandler implements AuthenticationSuccessHandler{

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //mlk essa porra aqui embaixo tava fudendo o programa, hj foram 3 horas tentando resolver essas duas linhas
        var authourities = authentication.getAuthorities(); //esse método pega as roles do usuário que vem no header http authorization ou busca na base de dados
        //acontecee que esse callback com o map e o findFirst ta fazendo o mapeamento completo no mommento de login agora
        //antes ele verificava qual a role na hora do cadastro(pensei que fazia mais sentido), mas como no cadastro a gente não define as roles, o programa quebrava e não tinha como fazer login
        //te mandei o video, o erro era por causa daquilo, mas Graças a Deus foi resolvido
        var roles = authourities.stream().map(r -> r.getAuthority()).findFirst(); //aqui o mapeamento buscando a role


        if(roles.orElse("").equals("ADMIN")) {
            response.sendRedirect("/admin-page");
        }else if(roles.orElse("").equals("ALUNO")){ //aqui é user ou aluno como roles -> muito possivelmente aluno
            response.sendRedirect("/aluno-page");//existe um desse tambem no arquivo de configuração do spring security
        }else if(roles.orElse("").equals("PROF")){
            response.sendRedirect("/prof-page");
        }else {
            response.sendRedirect("/error");
        }
    }
    
}
