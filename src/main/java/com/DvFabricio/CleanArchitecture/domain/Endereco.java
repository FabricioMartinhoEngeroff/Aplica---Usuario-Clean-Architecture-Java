package com.DvFabricio.CleanArchitecture.domain;

public class Endereco {


    private String logradouro;
    private String bairro;
    private String cep;
    private Integer numeroCasa;
    private String complemento;
    private String cidade;
    private String pais;

    public Endereco(String logradouro, String bairro, String cep, Integer numeroCasa, String complemento, String cidade, String pais) {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cep = cep;
        this.numeroCasa = numeroCasa;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(Integer numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}