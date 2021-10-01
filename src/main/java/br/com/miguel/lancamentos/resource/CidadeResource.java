package br.com.miguel.lancamentos.resource;

import br.com.miguel.lancamentos.model.Cidade;
import br.com.miguel.lancamentos.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cidades")
public class CidadeResource {

    @Autowired
    private CidadeRepository cidadeRepository;

    @GetMapping("/todas")
    public List<Cidade> listarTodasCidades(){return cidadeRepository.findAll(Sort.by("nome"));}

    @GetMapping("/{id}")
    public ResponseEntity<Cidade> buscarPeloCodigo(@PathVariable Long id){
        Optional<Cidade> cidade = cidadeRepository.findById(id);
        return cidade.isPresent() ? ResponseEntity.ok(cidade.get()) : ResponseEntity.notFound().build();
    }
}
