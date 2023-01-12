package br.com.arcenio.Gerenciar.Pessoas.service;

import br.com.arcenio.Gerenciar.Pessoas.controller.filtro.PessoaFiltro;
import br.com.arcenio.Gerenciar.Pessoas.entity.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PessoaService {

    Pessoa adicionar(Pessoa pessoa);

    Page<Pessoa> listaPessoas(PessoaFiltro pessoaFiltro, Pageable pageable);
    Optional<Pessoa> buscarPorId(Long id);
    Object removerPorId(Long id);
}
