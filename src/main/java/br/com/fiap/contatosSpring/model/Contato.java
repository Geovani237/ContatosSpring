package br.com.fiap.contatosSpring.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_contatos")
public class Contato {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "CONTATOS_SEQ"
    )
    @SequenceGenerator(
            name = "CONTATOS_SEQ",
            sequenceName = "CONTATOS_SEQ",
            allocationSize = 1
    )
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private LocalDate dataNascimento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
