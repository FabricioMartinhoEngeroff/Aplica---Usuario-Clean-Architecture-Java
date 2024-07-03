package com.DvFabricio.CleanArchitecture.application.usecases;

import com.DvFabricio.CleanArchitecture.application.gateways.RepositorioDeUsuario;
import com.DvFabricio.CleanArchitecture.domain.entities.Usuario;

import java.util.List;

public class ListarUsuarios {

    private final RepositorioDeUsuario repositorio;

    public ListarUsuarios(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public List<Usuario> obterTodosUsuario(){
        return this.repositorio.listarTodos();
    }


}
