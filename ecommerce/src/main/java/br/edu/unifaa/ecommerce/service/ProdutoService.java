package br.edu.unifaa.ecommerce.service;

import br.edu.unifaa.ecommerce.model.Produto;
import br.edu.unifaa.ecommerce.model.exception.ResourceNotFoundException;
import br.edu.unifaa.ecommerce.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    
    @Autowired // Pedindo o controle dessa classe para utilização
    private ProdutoRepository produtoRepository;

    public Produto adicionar(Produto produto){
        produto.setId (0);
        
        return produtoRepository.save(produto);
    }

    public List<Produto> obterTodos(){

        return produtoRepository.findAll();
    }

    public Optional<Produto> obterPorId(Long id){

        Optional<Produto> produtoLocalizado = produtoRepository.findById(id);
    
        if (produtoLocalizado.isEmpty()) {
            throw new ResourceNotFoundException("Não foi encontrado produto com id: " + id);
        }

        return produtoLocalizado;
    }

    public Produto atualizar(Long id, Produto produto){
         
        obterPorId(id);
        produto.setId(id);
        
        return produtoRepository.save(produto);
    }

    public void deletar(Long id){
    
        obterPorId(id);
        produtoRepository.deleteById(id);
}
}
