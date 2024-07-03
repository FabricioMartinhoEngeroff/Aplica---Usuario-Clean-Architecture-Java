package com.DvFabricio.CleanArchitecture.infra.controller;

import com.DvFabricio.CleanArchitecture.application.usecases.AtualizarUsuario;
import com.DvFabricio.CleanArchitecture.application.usecases.CriarUsuario;
import com.DvFabricio.CleanArchitecture.application.usecases.ExcluirUsuario;
import com.DvFabricio.CleanArchitecture.application.usecases.ListarUsuarios;
import com.DvFabricio.CleanArchitecture.domain.entities.Usuario;
import com.DvFabricio.CleanArchitecture.infra.gateway.UsuarioEntityMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final CriarUsuario criarUsuario;
    private final ListarUsuarios listarUsuarios;
    private final AtualizarUsuario atualizarUsuario;
    private final ExcluirUsuario excluirUsuario;

    public UsuarioController(CriarUsuario criarUsuario, ListarUsuarios listarUsuarios,
                             AtualizarUsuario atualizarUsuario, ExcluirUsuario excluirUsuario) {
        this.criarUsuario = criarUsuario;
        this.listarUsuarios = listarUsuarios;
        this.atualizarUsuario = atualizarUsuario;
        this.excluirUsuario = excluirUsuario;
    }

    @PostMapping
    public UsuarioDto cadastrarUsuario(@RequestBody UsuarioDto dto) {
        Usuario salvo = criarUsuario.cadastrarUsuario(new Usuario(dto.id(),dto.cpf(), dto.nome(), dto.nascimento(),
                dto.email()));

        return new UsuarioDto(salvo.getId(),salvo.getCpf(), salvo.getNome(), salvo.getNascimento(), salvo.getEmail());

    }

    @GetMapping
    public List<UsuarioDto> listarUsuarios() {
        return listarUsuarios. obterTodosUsuario().stream()
                .map(u -> new UsuarioDto(u.getId(),u.getCpf(), u.getNome(), u.getNascimento(), u.getEmail()))
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public UsuarioDto atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioDto dto) {
        Usuario usuario = new Usuario(id, dto.cpf(), dto.nome(), dto.nascimento(), dto.email());
        Usuario atualizado = atualizarUsuario.atualizar(usuario);
        return new UsuarioDto(atualizado.getId(), atualizado.getCpf(), atualizado.getNome(), atualizado.getNascimento(), atualizado.getEmail());
    }

    @DeleteMapping("/{id}")
    public void excluirUsuario(@PathVariable Long id) {
        excluirUsuario.excluir(id.toString());
    }


}