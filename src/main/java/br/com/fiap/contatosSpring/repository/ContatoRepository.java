package br.com.fiap.contatosSpring.repository;

import br.com.fiap.contatosSpring.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ContatoRepository extends JpaRepository<Contato, Long> {


    @Query("SELECT c FROM Contato c WHERE c.nome = :nome")
    public Optional<Contato> findByNome(@Param("nome") String nome);

    @Query("SELECT c FROM Contato c WHERE c.dataNascimento BETWEEN :dataInicio AND :dataFinal")
    public List<Contato> findByDataNascimentoBetween(
            @Param("dataInicio") LocalDate dataInicio,
            @Param("dataFinal") LocalDate dataFinal
    );

    Optional<Contato> findByEmail(String email);
}
