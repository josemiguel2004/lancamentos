package br.com.miguel.lancamentos.resource;

import br.com.miguel.lancamentos.model.Cidade;
import br.com.miguel.lancamentos.model.Estado;
import br.com.miguel.lancamentos.repository.EstadoRepository;
import br.com.miguel.lancamentos.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estados")
public class EstadoResource {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private EstadoService estadoService;

    @GetMapping("/todas")
    public List<Estado> listarTodosEstados(){return estadoRepository.findAll(Sort.by("nome"));}

    @GetMapping("/{id}")
    public ResponseEntity<Estado> buscarPeloCodigo(@PathVariable Long id){
        Optional<Estado> estado = estadoRepository.findById(id);
        return estado.isPresent() ? ResponseEntity.ok(estado.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<Estado> criar(@RequestBody Estado estado, HttpServletResponse response){
        Estado estadoSalvo= estadoService.salvar(estado);
        return ResponseEntity.status(HttpStatus.CREATED).body(estadoSalvo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id){
        estadoRepository.deleteById(id);
    }
}
