package br.com.miguel.lancamentos.service;

import br.com.miguel.lancamentos.model.Lancamento;
import br.com.miguel.lancamentos.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;

   public Lancamento salvar(Lancamento lancamento) {return lancamentoRepository.save(lancamento);}

    public Lancamento buscarLancamentoPorId (Long id){
        Optional<Lancamento> lancamentoSalvo = lancamentoRepository.findById(id);

        if(!lancamentoSalvo.isPresent()){
            throw  new IllegalArgumentException();
        }

        return lancamentoSalvo.get();
    }
}
