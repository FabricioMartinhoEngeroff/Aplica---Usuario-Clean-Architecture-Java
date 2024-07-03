package com.DvFabricio.CleanArchitecture.infra.gateway;

import com.DvFabricio.CleanArchitecture.domain.entities.Usuario;
import com.DvFabricio.CleanArchitecture.infra.persistence.UsuarioEntity;

public class UsuarioEntityMapper {

    public UsuarioEntity toEntity(Usuario usuario){
        return new UsuarioEntity(usuario.getId(), usuario.getCpf(), usuario.getNome(),
                usuario.getNascimento(), usuario.getEmail());
    }

    public Usuario toDomain(UsuarioEntity entity){
        return new Usuario(entity.getId(), entity.getCpf(), entity.getNome(), entity.getNascimento(),
                entity.getEmail());
    }
}