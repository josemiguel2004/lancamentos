package br.com.miguel.lancamentos.service;

import br.com.miguel.lancamentos.model.Lancamento;
import br.com.miguel.lancamentos.repository.LancamentoRepository;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;

   public Lancamento salvar(Lancamento lancamento) {return lancamentoRepository.save(lancamento);}

    public Lancamento atualizar(Long id, Lancamento lancamento){
       Lancamento lancamentoSalvo = buscarLancamentoPorId(id);

        BeanUtils.copyProperties(lancamento,lancamentoSalvo,"id");

        return lancamentoRepository.save(lancamentoSalvo);
    }

    public Lancamento buscarLancamentoPorId (Long id){
        Optional<Lancamento> lancamentoSalvo = lancamentoRepository.findById(id);

        if(!lancamentoSalvo.isPresent()){
            throw  new IllegalArgumentException();
        }

        return lancamentoSalvo.get();
    }
}
