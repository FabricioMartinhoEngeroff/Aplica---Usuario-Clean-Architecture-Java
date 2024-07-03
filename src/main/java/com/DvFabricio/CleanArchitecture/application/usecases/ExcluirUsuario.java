package com.DvFabricio.CleanArchitecture.application.usecases;

import com.DvFabricio.CleanArchitecture.application.gateways.RepositorioDeUsuario;

public class ExcluirUsuario {

    private final RepositorioDeUsuario repositorio;

    public ExcluirUsuario(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public void  excluir(String id) {
        repositorio.excluirUsuario(id);
    }

}
