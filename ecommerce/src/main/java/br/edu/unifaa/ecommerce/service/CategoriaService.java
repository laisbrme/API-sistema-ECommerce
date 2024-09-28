package br.edu.unifaa.ecommerce.service;

import br.edu.unifaa.ecommerce.model.Categoria;
import br.edu.unifaa.ecommerce.model.exception.ResourceNotFoundException;
import br.edu.unifaa.ecommerce.model.exception.ResourceBadRequestException;
import br.edu.unifaa.ecommerce.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    
    @Autowired // Pedindo o controle dessa classe para utilização
    private CategoriaRepository categoriaRepository;

    public Categoria adicionar(Categoria categoria){
        categoria.setId (0);
        
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> obterTodos(){

        return categoriaRepository.findAll();
    }

    public Optional<Categoria> obterPorId(Long id){

        Optional<Categoria> categoriaLocalizado = categoriaRepository.findById(id);
    
        if (categoriaLocalizado.isEmpty()) {
            throw new ResourceNotFoundException("Não foi encontrado categoria com id: " + id);
        }

        return categoriaLocalizado;
    }

    public Categoria atualizar(Long id, Categoria categoria){
         
        obterPorId(id);
        categoria.setId(id);
        
        return categoriaRepository.save(categoria);
    }

    public void deletar(Long id){
    
        obterPorId(id);
        categoriaRepository.deleteById(id);
}
}
