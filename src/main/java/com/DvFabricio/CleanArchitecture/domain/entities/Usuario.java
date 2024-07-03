package com.DvFabricio.CleanArchitecture.domain.entities;

import com.DvFabricio.CleanArchitecture.domain.Endereco;

import java.time.LocalDate;
import java.time.Period;

public class Usuario {

    private Long id;
    private String cpf;
    private String nome;
    private LocalDate nascimento;
    private String email;
    private Endereco endereco;

    public Usuario(Long id,String cpf, String nome, LocalDate nascimento, String email) {
        if (cpf == null || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
            throw new IllegalArgumentException("Cpf no padrão incorreto!");
        }
        if (nome == null) {
            throw new IllegalArgumentException("Nome não pode ser nulo!");
        }
        if (email == null) {
            throw new NullPointerException("Email não pode ser nulo!");
        } else if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new IllegalArgumentException("Email no padrão incorreto!");
        }

        int idade = Period.between(nascimento, LocalDate.now()).getYears();
        if (idade < 18) {
            throw new IllegalArgumentException("Usuário deve ter pelo menos 18 anos de idade!");
        }

        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = nascimento;
        this.email = email;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", nascimento=" + nascimento +
                ", email='" + email + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}