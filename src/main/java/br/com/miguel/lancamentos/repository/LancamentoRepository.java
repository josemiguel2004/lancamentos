package br.com.miguel.lancamentos.repository;

import br.com.miguel.lancamentos.model.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentoRepository  extends JpaRepository<Lancamento, Long> {
}
