package br.edu.unifaa.ecommerce.service;

import br.edu.unifaa.ecommerce.model.Endereco;
import br.edu.unifaa.ecommerce.model.exception.ResourceBadRequestException;
import br.edu.unifaa.ecommerce.model.exception.ResourceNotFoundException;
import br.edu.unifaa.ecommerce.repository.EnderecoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    
    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco adicionar(Endereco endereco){

        if(endereco.getCep().equals("")){
            throw new ResourceBadRequestException("O CEP não pode ser vazio.");
        }
        endereco.setId(0);

        return enderecoRepository.save(endereco);
    }

    public List<Endereco> obterTodos(){

        return enderecoRepository.findAll();
    }

    public Optional<Endereco> obterPorId(Long id){
        
        Optional<Endereco> enderecoLocalizado =  enderecoRepository.findById(id);

        if(enderecoLocalizado.isEmpty()){
            throw new ResourceNotFoundException("Não foi possível encontrar um endereço com o id: " + id);
        }

        return enderecoLocalizado;
    }

    public Endereco atualizar(long id, Endereco endereco){

        obterPorId(id);
        endereco.setId(id);
        if(endereco.getCep().equals("")){
            throw new ResourceBadRequestException("O CEP não pode ser vazio.");
        }

        return enderecoRepository.save(endereco);
    }

    public void deletar(long id){

        obterPorId(id);
        enderecoRepository.deleteById(id);
    }
}
