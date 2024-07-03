package com.DvFabricio.CleanArchitecture.application.usecases;


import com.DvFabricio.CleanArchitecture.application.gateways.RepositorioDeUsuario;
import com.DvFabricio.CleanArchitecture.domain.entities.Usuario;

public class CriarUsuario {

    private final RepositorioDeUsuario repositorio;

    public CriarUsuario(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
        return repositorio.cadastrarUsuario(usuario);
    }
}
