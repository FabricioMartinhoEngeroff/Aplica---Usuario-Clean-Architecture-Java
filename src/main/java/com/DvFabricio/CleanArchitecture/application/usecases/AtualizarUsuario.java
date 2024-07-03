package com.DvFabricio.CleanArchitecture.application.usecases;

import com.DvFabricio.CleanArchitecture.application.gateways.RepositorioDeUsuario;
import com.DvFabricio.CleanArchitecture.domain.entities.Usuario;

public class AtualizarUsuario {

    private final RepositorioDeUsuario repositorio;

    public AtualizarUsuario(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public Usuario atualizar(Usuario usuario) {
        repositorio.atualizarUsuario(usuario);
        return usuario;
    }
}
