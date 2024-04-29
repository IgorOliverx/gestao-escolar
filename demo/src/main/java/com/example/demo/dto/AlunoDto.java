package com.example.demo.dto;

/*
* Essa classe DTO permite encapsular(mais pra frente) a 
* entidade Aluno, em um objeto simples de manipular para o spring
* pense que ao invés de mexer no objeto, ele manipula uma cópia
* "data transfer object" -> meu Model pode ter mais atributos, mas aqui, ficam somente aqueles que quero transferir, no caso cadastrar no banco de dados
*/
public class AlunoDto {

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

    public AlunoDto(String nome, String telefone, String cpf, String curso, String email, String senha, String nota, String falta, String professor, String horario, String role) {
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
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
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
