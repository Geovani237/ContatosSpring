package br.com.fiap.contatosSpring.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record ContatoCadastroDto(
        Long id,

        @NotBlank(message = "Nome do contato é obrigatório!")
        String nome,

        @NotBlank(message = "O E-mail é obrigatório!")
        @Email(message = "o e-mail está com formato inválido!")
        String email,

        @NotBlank(message = "Senha é obrigatória!")
        @Size(min = 4, max = 15, message = "A senha deve conter entre 4 e 15 caracteres.")
        String senha,

        @NotNull(message = "Data de nascimento obrigatória!")
        LocalDate dataNascimento
) {
}
