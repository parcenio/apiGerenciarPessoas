package br.com.arcenio.Gerenciar.Pessoas;

import br.com.arcenio.Gerenciar.Pessoas.controller.filtro.PessoaFiltro;
import br.com.arcenio.Gerenciar.Pessoas.entity.Pessoa;
import br.com.arcenio.Gerenciar.Pessoas.repository.PessoaRepository;
import br.com.arcenio.Gerenciar.Pessoas.service.impl.PessoaServiceImpl;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
public class PessoaServiceTest {

    private PessoaServiceImpl pessoaServiceImpl;
    private final PessoaRepository pessoaRepository;
    private final ModelMapper modelMapper;
    private PessoaFiltro pessoaFiltroExample;
    private Pessoa pessoaExample;

    @BeforeEach
    void exemploPessoa(){
        pessoaServiceImpl = new PessoaServiceImpl(pessoaRepository,modelMapper);
        pessoaFiltroExample = PessoaExample.criarPessoaFiltroFake();
        pessoaExample = PessoaExample.criarPessoaFake();
    }

    @Test
    @ParameterizedTest
    @DisplayName("Criar Pessoa")
    void testCriarPessoa(){
        assertEquals(HttpStatus.CREATED,
                pessoaServiceImpl.adicionar(PessoaExample.criarPessoaFake()) );
    }

    @Test
    @ParameterizedTest
    @DisplayName("Testando listar as pessoas registradas")
    void testListarPessoas(){
        assertEquals(HttpStatus.OK,
                pessoaServiceImpl.listaPessoas(pessoaFiltroExample, Pageable.ofSize(1)));
    }

    @Test
    @ParameterizedTest
    @DisplayName("Atualizando dados da Pessoa")
    void testAtualizarPessoa(){
        assertEquals(HttpStatus.NO_CONTENT,
                pessoaServiceImpl.atualizarPessoa(1L,pessoaExample));
    }

    @ParameterizedTest
    @DisplayName("Removendo uma Pessoa")
    void testRemoverPessoa(){
        assertEquals(HttpStatus.NO_CONTENT,
                pessoaServiceImpl.removerPorId(pessoaExample.getId()));
    }
}
