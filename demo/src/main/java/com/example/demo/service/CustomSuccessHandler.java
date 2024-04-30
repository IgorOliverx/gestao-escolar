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
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        var authourities = authentication.getAuthorities();

        var roles = authourities.stream().map(r -> r.getAuthority()).findFirst(); //aqui o mapeamento buscando a role


        if (roles.orElse("").equals("ADMIN")) {
            response.sendRedirect("/admin-page");
        } else if (roles.orElse("").equals("ALUNO")) { //aqui é user ou aluno como roles -> muito possivelmente aluno
            response.sendRedirect("/aluno-page");//existe um desse tambem no arquivo de configuração do spring security
        } else if (roles.orElse("").equals("PROF")) {
            response.sendRedirect("/prof-page");
        } else {
            response.sendRedirect("/error");
        }
    }

}
