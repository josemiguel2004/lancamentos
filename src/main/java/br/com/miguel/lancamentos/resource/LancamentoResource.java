package br.com.miguel.lancamentos.resource;


import br.com.miguel.lancamentos.model.Lancamento;
import br.com.miguel.lancamentos.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoResource {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @GetMapping("/todos")
    public List<Lancamento> listarTodosLancamentos(){
        return lancamentoRepository.findAll(Sort.by("data_vencimento").ascending());
    }
}
