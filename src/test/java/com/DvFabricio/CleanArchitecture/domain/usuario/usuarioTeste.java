package com.DvFabricio.CleanArchitecture.domain.usuario;

import com.DvFabricio.CleanArchitecture.domain.Endereco;
import com.DvFabricio.CleanArchitecture.domain.entities.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class usuarioTeste {

    @Test
    public void naoDeveCadastrarUsuarioComCpfNoFormatoInvalido() {
        String[] cpfsInvalidos = {
                "123456789",
                "123456789999",
                "12345a78999",
                "11111111111",
                "12345678900",
                "12345678909",
                "           "
        };

        for (String cpf : cpfsInvalidos) {
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> new Usuario(null, cpf, "Fabricio", LocalDate.parse("1990-09-08"), "email@email.com"));
        }
    }


    @Test
    public void naoDeveCadastrarUsuarioComMenosDe18anos() {

        LocalDate dataNascimento = LocalDate.now().minusYears(17);

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Usuario(null, "123.456.789-00", "Felipe", dataNascimento, "felipe@gmail.com");
        });

        Assertions.assertEquals("Usuário deve ter pelo menos 18 anos de idade!", exception.getMessage());
    }

    @Test
    public void naoDeveCadastrarUsuarioComCpfNulo() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario(null, null, "Fabricio", LocalDate.parse("1990-09-08"), "email@email.com"));
    }

    @Test
    public void naoDeveCadastrarUsuarioComNomeNulo() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario(null, "123.456.789-00", null, LocalDate.parse("1990-09-08"), "email@email.com"));
    }

    @Test
    public void naoDeveCadastrarUsuarioComEmailNulo() {
        Assertions.assertThrows(NullPointerException.class,
                () -> new Usuario(null, "123.456.789-00", "Fabricio", LocalDate.parse("1990-09-08"), null));
    }

    @Test
    public void naoDeveCadastrarUsuarioComEmailInvalido() {
        String[] emailsInvalidos = {
                "email.com",
                "email@",
                "email@com",
                "email@.com",
                "email@com.",
                "email@com.c",
                "email@.com.c",
                "email@@com.com"
        };

        for (String email : emailsInvalidos) {
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> new Usuario(null, "123.456.789-00", "Fabricio", LocalDate.parse("1990-09-08"), email));
        }
    }

    @Test
    public void deveSetarEnderecoNoUsuario() {
        Usuario usuario = new Usuario(null, "123.456.789-00", "Fabricio", LocalDate.parse("1990-09-08"), "email@email.com");
        Endereco endereco = new Endereco("Rua A", "Centro", "12345-678", 100, "Apto 101", "Cidade", "País");
        usuario.setEndereco(endereco);

        Assertions.assertEquals("Rua A", usuario.getEndereco().getLogradouro());
        Assertions.assertEquals("Centro", usuario.getEndereco().getBairro());
        Assertions.assertEquals("12345-678", usuario.getEndereco().getCep());
        Assertions.assertEquals(100, usuario.getEndereco().getNumeroCasa());
        Assertions.assertEquals("Apto 101", usuario.getEndereco().getComplemento());
        Assertions.assertEquals("Cidade", usuario.getEndereco().getCidade());
        Assertions.assertEquals("País", usuario.getEndereco().getPais());
    }
}

