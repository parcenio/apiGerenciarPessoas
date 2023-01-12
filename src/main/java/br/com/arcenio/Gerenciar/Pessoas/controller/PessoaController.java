package br.com.arcenio.Gerenciar.Pessoas.controller;

import br.com.arcenio.Gerenciar.Pessoas.controller.filtro.PessoaFiltro;
import br.com.arcenio.Gerenciar.Pessoas.entity.Pessoa;
import br.com.arcenio.Gerenciar.Pessoas.service.impl.PessoaServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaServiceImpl pessoaService;
    private final ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa adicionar(@RequestBody Pessoa pessoa){
        return pessoaService.adicionar(pessoa);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Pessoa> listaPessoas(PessoaFiltro pessoaFiltro, Pageable pageable){
        return pessoaService.listaPessoas(pessoaFiltro,pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pessoa buscarPessoaPorId(@PathVariable("id") Long id){
        return pessoaService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Pessoa não encontrada."));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerPessoa(@PathVariable("id") Long id){
        pessoaService.buscarPorId(id)
                .map(pessoa -> {
                    pessoaService.removerPorId(pessoa.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Pessoa não encontrada."));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarPessoa(@PathVariable("id") Long id, @RequestBody Pessoa pessoa){
        pessoaService.buscarPorId(id)
                .map(pessoaBase -> {
                    modelMapper.map(pessoa, pessoaBase);
                    pessoaService.adicionar(pessoaBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Pessoa não encontrada."));
    }
}
