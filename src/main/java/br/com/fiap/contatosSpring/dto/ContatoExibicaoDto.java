package br.com.fiap.contatosSpring.dto;

import br.com.fiap.contatosSpring.model.Contato;

import java.time.LocalDate;

public record ContatoExibicaoDto(
        Long id,
        String nome,
        String email,
        LocalDate dataNascimento
) {
    public ContatoExibicaoDto(Contato contato) {
        this(
                contato.getId(),
                contato.getNome(),
                contato.getEmail(),
                contato.getDataNascimento());
    }
}
