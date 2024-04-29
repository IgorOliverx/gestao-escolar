package com.example.demo.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;


/**
 * Model Aluno(deveria ter herdado de uma classe abstrata, já disse, mas deixa assim)
*/
@jakarta.persistence.Entity
@Table(name="alunos", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Aluno {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   private String nome;

   private String telefone;

   private String cpf;

   private String curso;

   private String email;

   private String senha;

   private String nota;

   private String falta;

   private String professor;

   private String horario;

   private String role;




   public Aluno(){super();}

   public Aluno(String nome, String telefone, String cpf, String curso, String email, String senha, String nota, String falta, String professor, String horario, String role){
   
    this.nome = nome;
    this.telefone = telefone;
    this.cpf = cpf;
    this.curso = curso;
    this.email = email;
    this.senha = senha;
    this.nota = nota;
    this.falta = falta;
    this.professor = professor;
    this.horario = horario;
    this.role = role;
   }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCurso() {
        return this.curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getFalta() {
        return falta;
    }

    public void setFalta(String falta) {
        this.falta = falta;
    }
    

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}

