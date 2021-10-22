package br.com.miguel.lancamentos.service;

import br.com.miguel.lancamentos.model.Cidade;
import br.com.miguel.lancamentos.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public Cidade salvar(Cidade cidade){return cidadeRepository.save(cidade); }

    public Cidade buscarCidadePorId (Long id){
        Optional<Cidade> cidadeSalva = cidadeRepository.findById(id);

        if(!cidadeSalva.isPresent()){
            throw new IllegalArgumentException();
        }
        return  cidadeSalva.get();
    }
}
