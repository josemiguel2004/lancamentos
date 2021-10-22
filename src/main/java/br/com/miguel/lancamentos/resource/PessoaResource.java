package br.com.miguel.lancamentos.resource;

import br.com.miguel.lancamentos.model.Pessoa;
import br.com.miguel.lancamentos.repository.PessoaRepository;
import br.com.miguel.lancamentos.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/todas")
    public List<Pessoa> listarTodasPessoas(){return pessoaRepository.findAll(Sort.by("nome").ascending());}

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPeloCodigo(@PathVariable Long id){
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        return pessoa.isPresent()? ResponseEntity.ok(pessoa.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<Pessoa> criar(@RequestBody Pessoa pessoa , HttpServletResponse response){
        Pessoa pessoaSalva = pessoaService.salvar(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
    }

}
