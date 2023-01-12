package br.com.arcenio.Gerenciar.Pessoas.repository;

import br.com.arcenio.Gerenciar.Pessoas.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PessoaRepository extends JpaRepository<Pessoa, Long> {


}
