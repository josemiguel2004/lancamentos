package br.com.miguel.lancamentos.service;

import br.com.miguel.lancamentos.model.Categoria;
import br.com.miguel.lancamentos.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
private CategoriaRepository categoriaRepository;

    public Categoria buscarCategoriaPorId(Long id){
        Optional<Categoria> categoriaSalva = categoriaRepository.findById(id);

        if(!categoriaSalva.isPresent()){
            throw new IllegalArgumentException();
        }
        return categoriaSalva.get();
    }
}
