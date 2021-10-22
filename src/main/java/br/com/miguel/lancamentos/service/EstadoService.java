package br.com.miguel.lancamentos.service;

import br.com.miguel.lancamentos.model.Estado;
import br.com.miguel.lancamentos.repository.EstadoRepository;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public Estado salvar(Estado estado){return estadoRepository.save(estado); }

    public Estado buscarEstadoPorId (Long id){
        Optional<Estado> estadoSalvo = estadoRepository.findById(id);

        if(!estadoSalvo.isPresent()){
            throw new IllegalArgumentException();
        }
        return estadoSalvo.get();
    }
}
