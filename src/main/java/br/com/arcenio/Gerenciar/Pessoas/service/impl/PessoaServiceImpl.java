package br.com.arcenio.Gerenciar.Pessoas.service.impl;

import br.com.arcenio.Gerenciar.Pessoas.controller.filtro.PessoaFiltro;
import br.com.arcenio.Gerenciar.Pessoas.entity.Pessoa;
import br.com.arcenio.Gerenciar.Pessoas.repository.PessoaRepository;
import br.com.arcenio.Gerenciar.Pessoas.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;
    private final ModelMapper modelMapper;

    public Pessoa adicionar(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    public Page<Pessoa> listaPessoas(PessoaFiltro pessoaFiltro, Pageable pageable){
        Pessoa pessoa = Pessoa.builder()
                .id(pessoaFiltro.getId())
                .nome(pessoaFiltro.getNome())
                .dataDeNascimento(pessoaFiltro.getDataDeNascimento())
                .endereco(pessoaFiltro.getEndereco())
                .build();

        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withIgnoreNullValues()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(pessoa, exampleMatcher);

        return pessoaRepository.findAll(example,pageable);
    }

    public Optional<Pessoa> buscarPorId(Long id){
        return pessoaRepository.findById(id);
    }

    public Object removerPorId(Long id){
        pessoaRepository.deleteById(id);
        return null;
    }

//    public Object atualizarPessoa(Long id, Pessoa pessoa){
//        final Pessoa pessoaResponse;
//        pessoaRepository.findById(id)
//                .map(pessoaBase -> {
//                    modelMapper.map(pessoa.getEndereco(),pessoaBase.getEndereco());
//                    modelMapper.map(pessoa, pessoaBase);
//                    pessoaRepository.deleteById(pessoa.getId());
//                    pessoaRepository.save(pessoaBase);
//                    return Void.TYPE;
//                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Pessoa não encontrada."));
//        return null;
//    }
}
