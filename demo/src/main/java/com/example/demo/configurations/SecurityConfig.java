package com.example.demo.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.service.CustomAlunoDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    //porra fiquei usando o import errado vai toma no cuuuuuuuuuuuuuuuuuuu
    //aloisio boi bandido seu lixo 
    //@Autowired
    //CustomAlunoDetail customAlunoDetail;

    @Autowired
    CustomAlunoDetailService customAlunoDetailService;
    
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.csrf(c -> c.disable()).authorizeHttpRequests(request -> request.requestMatchers("/admin-page")
            .permitAll().requestMatchers("/aluno-page").permitAll()
            .requestMatchers("/registration", "/css/**"). permitAll()
            .anyRequest().authenticated())

            .formLogin(form -> form.loginPage("/login").loginProcessingUrl("/login")
                .defaultSuccessUrl("/").permitAll())

                .logout(form -> form.invalidateHttpSession(true).clearAuthentication(true)
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/login?logout").permitAll());


                    return http.build();
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth)throws Exception{
        auth.userDetailsService(customAlunoDetailService).passwordEncoder(passwordEncoder());
    }
    
}
