package com.DvFabricio.CleanArchitecture;

import com.DvFabricio.CleanArchitecture.domain.entities.Usuario;
import com.DvFabricio.CleanArchitecture.infra.gateway.RepositorioDeUsuarioEmArquivo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class UtilizaUsuarioComArquivos {

	public static void main(String[] args) {
		RepositorioDeUsuarioEmArquivo repositorioDeUsuarioEmArquivo = new RepositorioDeUsuarioEmArquivo();

		repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario(1L,"456.789.888-88", "João", LocalDate.parse("2000-10-15"), "joao@email.com"));
		repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario(2L,"456.789.888-88", "Maria", LocalDate.parse("2000-10-15"), "maria@email.com"));
		repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario(3L,"456.789.888-88", "Vinicios", LocalDate.parse("2000-10-15"), "vinicios@email.com"));
		repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario(4L,"456.789.888-88", "Raphael", LocalDate.parse("2000-10-15"), "raphael@email.com"));

		//System.out.println(repositorioDeUsuarioEmArquivo.listarTodos());
		repositorioDeUsuarioEmArquivo.gravaEmArquivo("usuarios.txt");
	}
}
