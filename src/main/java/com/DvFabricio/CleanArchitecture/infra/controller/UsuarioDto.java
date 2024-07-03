package com.DvFabricio.CleanArchitecture.infra.controller;

import com.DvFabricio.CleanArchitecture.domain.Endereco;

import java.time.LocalDate;

public record UsuarioDto(Long id,String cpf,
                         String nome,
                         LocalDate nascimento,
                         String email
                        ) {
}
