package br.edu.unifaa.ecommerce.repository;

import br.edu.unifaa.ecommerce.model.Endereco;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;

@Repository
public class EnderecoRepository {
    // Comunicação em memória com o banco de dados.
    private List<Endereco> enderecos = new ArrayList<Endereco>();
    private int ultimoId = 0;

    public Endereco adicionar(Endereco endereco){

        ultimoId++;
        endereco.setId(ultimoId);
        enderecos.add(endereco);

        return endereco;
    }

    public List<Endereco> obterTodos(){
        
        return enderecos;
    }

    public Endereco obterPorId(Long id){

        for(Endereco endereco : enderecos){

            if(endereco.getId() == id){

                return endereco;
            }
        }

        return new Endereco();
    }
}
