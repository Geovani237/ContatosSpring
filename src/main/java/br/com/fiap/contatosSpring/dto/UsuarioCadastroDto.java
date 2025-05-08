package br.com.fiap.contatosSpring.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioCadastroDto(

        Long usuarioId,

        @NotBlank(message = "O nome do usuário é obrigatório!")
        String nome,

        @NotBlank(message = "O e-mail do usuário é obrigatório!")
        @Email(message = "O e-mail do usúario não é válido!")
        String email,

        @NotBlank(message = "O senha é obrigatório!")
        @Size(min = 6, max = 20, message = "A senha deve conter entre 6 a 20 caracteres")
        String senha
) {
}
