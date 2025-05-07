package br.com.fiap.contatosSpring.controller;

import br.com.fiap.contatosSpring.dto.ContatoCadastroDto;
import br.com.fiap.contatosSpring.dto.ContatoExibicaoDto;
import br.com.fiap.contatosSpring.model.Contato;
import br.com.fiap.contatosSpring.service.ContatoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ContatoController {

    @Autowired
    private ContatoService service;

    @PostMapping("/contatos")
    @ResponseStatus(HttpStatus.CREATED)
    public ContatoExibicaoDto gravar(@RequestBody @Valid ContatoCadastroDto contatoCadastroDto) {
        return service.gravar(contatoCadastroDto);
    }

    @GetMapping("/contatos")
    @ResponseStatus(HttpStatus.OK)
    public List<Contato> listarTodosOsContatos(){
        return service.listarTodosOsContatos();
    }

    @GetMapping("/contatos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ContatoExibicaoDto buscarpeloId(@PathVariable("id") Long id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping("/contatos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }

    @PutMapping("/contatos")
    @ResponseStatus(HttpStatus.OK)
    public Contato atualizar(@RequestBody Contato contato){
        return service.atualizar(contato);
    }


    @GetMapping("/contatos/nome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public ContatoExibicaoDto buscarContatoPeloNome(@PathVariable String nome) {
        return service.buscarPeloNome(nome);
    }

    @GetMapping(value = "/contatos",params = {"dataInicio", "dataFinal"})
    @ResponseStatus(HttpStatus.OK)
    public List<ContatoExibicaoDto> mostrarAniversariantes(
            @RequestParam LocalDate dataInicio,
            @RequestParam LocalDate dataFinal
    ){
        return service.mostrarAniversariantes(dataInicio, dataFinal);
    }

    @GetMapping(value = "/contatos", params = "email")
    public ContatoExibicaoDto buscarContatoPeloEmail(@RequestParam String email){
        return service.buscarContatoPeloEmail(email);
    }
}
