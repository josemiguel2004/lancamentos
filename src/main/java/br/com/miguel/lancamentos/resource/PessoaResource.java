package br.com.miguel.lancamentos.resource;

import br.com.miguel.lancamentos.model.Pessoa;
import br.com.miguel.lancamentos.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping("/todas")
    public List<Pessoa> listarTodasPessoas(){return pessoaRepository.findAll(Sort.by("nome").ascending());}

}