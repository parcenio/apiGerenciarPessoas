package br.com.arcenio.Gerenciar.Pessoas.controller.filtro;

import br.com.arcenio.Gerenciar.Pessoas.entity.Endereco;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PessoaFiltro {

    private Long id;
    private String nome;
    private String dataDeNascimento;
    private List<Endereco> endereco;
}
