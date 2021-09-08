package br.com.miguel.lancamentos.resource;

import br.com.miguel.lancamentos.model.Cidade;
import br.com.miguel.lancamentos.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeResource {

    @Autowired
    private CidadeRepository cidadeRepository;

    @GetMapping("/todas")
    public List<Cidade> listarTodasCidades(){return cidadeRepository.findAll(Sort.by("nome"));}
}
