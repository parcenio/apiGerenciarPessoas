package br.com.arcenio.Gerenciar.Pessoas.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "enderecos")
@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String logradouro;
    private String cep;
    private Integer numero;
    private String cidade;
    private boolean principal;

}
