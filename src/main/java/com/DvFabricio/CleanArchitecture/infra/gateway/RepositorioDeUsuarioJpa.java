package com.DvFabricio.CleanArchitecture.infra.gateway;

import com.DvFabricio.CleanArchitecture.application.gateways.RepositorioDeUsuario;
import com.DvFabricio.CleanArchitecture.domain.entities.Usuario;
import com.DvFabricio.CleanArchitecture.infra.persistence.UsuarioEntity;
import com.DvFabricio.CleanArchitecture.infra.persistence.UsuarioRepository;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RepositorioDeUsuarioJpa implements RepositorioDeUsuario {

    private final UsuarioRepository repositorio;
    private final UsuarioEntityMapper mapper;

    public RepositorioDeUsuarioJpa(UsuarioRepository repositorio, UsuarioEntityMapper mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        UsuarioEntity entity = mapper.toEntity(usuario);
        repositorio.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<Usuario> listarTodos() {
        return repositorio.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }


    @Override
    public Usuario atualizarUsuario(Usuario usuario) {
        Optional<UsuarioEntity> entityOptional = repositorio.findById(Long.valueOf(usuario.getId()));
        if (entityOptional.isPresent()) {
            UsuarioEntity entity = mapper.toEntity(usuario);
            repositorio.save(entity);
            return mapper.toDomain(entity);
        } else {
            throw new IllegalArgumentException("Usuário não encontrado com o ID: " + usuario.getId());
        }
    }

    @Override
    public void excluirUsuario(String id) {
        Optional<UsuarioEntity> entityOptional = repositorio.findById(Long.valueOf(id));
        entityOptional.ifPresent(repositorio::delete);
    }
}



