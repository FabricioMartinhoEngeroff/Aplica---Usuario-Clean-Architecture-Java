package com.DvFabricio.CleanArchitecture.config;

import com.DvFabricio.CleanArchitecture.application.gateways.RepositorioDeUsuario;
import com.DvFabricio.CleanArchitecture.application.usecases.AtualizarUsuario;
import com.DvFabricio.CleanArchitecture.application.usecases.CriarUsuario;
import com.DvFabricio.CleanArchitecture.application.usecases.ExcluirUsuario;
import com.DvFabricio.CleanArchitecture.application.usecases.ListarUsuarios;
import com.DvFabricio.CleanArchitecture.infra.gateway.RepositorioDeUsuarioJpa;
import com.DvFabricio.CleanArchitecture.infra.gateway.UsuarioEntityMapper;
import com.DvFabricio.CleanArchitecture.infra.persistence.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig{

    @Bean
    CriarUsuario criarUsuario(RepositorioDeUsuario repositorioDeUsuario){
        return new CriarUsuario(repositorioDeUsuario);
    }

    @Bean
    ListarUsuarios listarUsuarios(RepositorioDeUsuario repositorioDeUsuario){
        return new ListarUsuarios(repositorioDeUsuario);
    }

    @Bean
    RepositorioDeUsuarioJpa criarRepositorioJpa(UsuarioRepository repositorio, UsuarioEntityMapper mapper){
        return new RepositorioDeUsuarioJpa(repositorio, mapper);
    }

    @Bean
    AtualizarUsuario atualizarUsuario(RepositorioDeUsuario repositorioDeUsuario) {
        return new AtualizarUsuario(repositorioDeUsuario);
    }

    @Bean
    ExcluirUsuario excluirUsuario(RepositorioDeUsuario repositorioDeUsuario) {
        return new ExcluirUsuario(repositorioDeUsuario);
    }

    @Bean
    UsuarioEntityMapper retornaMapper(){
        return new UsuarioEntityMapper();
    }
}