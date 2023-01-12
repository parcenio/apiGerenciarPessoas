package br.com.arcenio.Gerenciar.Pessoas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "pessoas")
@Entity
public class Pessoa  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Nome", nullable = false)
    private String nome;

    @Column(name = "DataDeNascimento")
    private String dataDeNascimento;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Endereco> endereco;

}
