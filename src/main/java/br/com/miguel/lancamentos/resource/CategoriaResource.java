package br.com.miguel.lancamentos.resource;

import br.com.miguel.lancamentos.model.Categoria;
import br.com.miguel.lancamentos.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/todas")
    public List<Categoria> listarTodasCategorias(){
        return categoriaRepository.findAll(Sort.by("nome").ascending());
    }
}
