package com.DvFabricio.CleanArchitecture.domain.entities;

import com.DvFabricio.CleanArchitecture.domain.Endereco;

import java.time.LocalDate;

public class FabricaDeUsuario {

    public Usuario comNomeCpfNascimentoEmail(Long id, String nome, String cpf, LocalDate nascimento, String email){
        return new Usuario(id,cpf, nome, nascimento, email);
    }

    public Usuario comEndereco(Usuario usuario, String bairro, String rua, String cep, Integer numeroCasa, String complemento, String cidade, String pais) {
        usuario.setEndereco(new Endereco(bairro, rua, cep, numeroCasa, complemento, cidade, pais));
        return usuario;
    }

}

