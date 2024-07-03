package com.DvFabricio.CleanArchitecture.application.gateways;


import com.DvFabricio.CleanArchitecture.domain.entities.Usuario;

import java.util.List;

public interface RepositorioDeUsuario {

    Usuario cadastrarUsuario(Usuario usuario);

    List<Usuario> listarTodos();

    Usuario atualizarUsuario(Usuario usuario);

    void excluirUsuario(String id);

}

