package br.com.miguel.lancamentos.service;

import br.com.miguel.lancamentos.model.Pessoa;
import br.com.miguel.lancamentos.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa salvar(Pessoa pessoa){return pessoaRepository.save(pessoa);}

    public Pessoa atualizar(Long id, Pessoa pessoa){
        Pessoa pessoaSalva = buscarPessoaPorId(id);

        BeanUtils.copyProperties(pessoa, pessoaSalva,"id");

        return pessoaRepository.save(pessoaSalva);
    }

    public Pessoa buscarPessoaPorId (Long id){
        Optional<Pessoa> pessoaSalva = pessoaRepository.findById(id);

        if(!pessoaSalva.isPresent()){
            throw new IllegalArgumentException();
        }
        return pessoaSalva.get();
    }
}
