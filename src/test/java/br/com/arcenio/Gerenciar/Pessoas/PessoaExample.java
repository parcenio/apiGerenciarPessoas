package br.com.arcenio.Gerenciar.Pessoas;

import br.com.arcenio.Gerenciar.Pessoas.controller.filtro.PessoaFiltro;
import br.com.arcenio.Gerenciar.Pessoas.entity.Endereco;
import br.com.arcenio.Gerenciar.Pessoas.entity.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;


@Builder
public class PessoaExample {

    private static final long ID = 1L;
    private static final String NOME = "Testando";
    private static final String NASCIMENTO = "22/03/1995";
    private static final List<Endereco> ENDERECO_LIST = Collections.emptyList();

    public static PessoaFiltro criarPessoaFiltroFake() {
        return PessoaFiltro.builder().id(ID)
                .nome(NOME)
                .dataDeNascimento(NASCIMENTO)
                .endereco(ENDERECO_LIST).build();
    }
    public static Pessoa criarPessoaFake() {
        return Pessoa.builder().id(ID)
                .nome(NOME)
                .dataDeNascimento(NASCIMENTO)
                .endereco(ENDERECO_LIST).build();
    }
}
