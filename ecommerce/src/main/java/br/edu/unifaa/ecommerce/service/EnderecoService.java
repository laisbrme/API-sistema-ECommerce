package br.edu.unifaa.ecommerce.service;

import br.edu.unifaa.ecommerce.model.Endereco;
import br.edu.unifaa.ecommerce.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import java.util.InputMismatchException;
import java.util.List;
// import java.util.Optional;

@Service
public class EnderecoService {
    
    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco adicionar(Endereco endereco){

        return enderecoRepository.adicionar(endereco);
    }

    public List<Endereco> obterTodos(){

        return enderecoRepository.obterTodos();
    }

    public Endereco obterPorId(Long id){
        
        return enderecoRepository.obterPorId(id);
    }
}
