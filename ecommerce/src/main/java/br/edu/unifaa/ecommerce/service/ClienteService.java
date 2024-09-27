package br.edu.unifaa.ecommerce.service;

import br.edu.unifaa.ecommerce.model.Cliente;
import br.edu.unifaa.ecommerce.model.exception.ResourceBadRequestException;
import br.edu.unifaa.ecommerce.model.exception.ResourceNotFoundException;
import br.edu.unifaa.ecommerce.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente adicionar(Cliente cliente){

        if(cliente.getCpf().equals("")){
            throw new ResourceBadRequestException("O CPF não pode ser vazio.");
        }
        cliente.setId(0);

        return clienteRepository.save(cliente);
    }

    public List<Cliente> obterTodos(){

        return clienteRepository.findAll();
    }

    public Optional<Cliente> obterPorId(Long id){
        
        Optional<Cliente> clienteLocalizado =  clienteRepository.findById(id);

        if(clienteLocalizado.isEmpty()){
            throw new ResourceNotFoundException("Não foi possível encontrar um cliente com o id: " + id);
        }

        return clienteLocalizado;
    }

    public Cliente atualizar(long id, Cliente cliente){

        obterPorId(id);
        cliente.setId(id);
        if(cliente.getCpf().equals("")){
            throw new ResourceBadRequestException("O CPF não pode ser vazio.");
        }

        return clienteRepository.save(cliente);
    }

    public void deletar(long id){

        obterPorId(id);
        clienteRepository.deleteById(id);
    }
}
