package br.edu.unifaa.ecommerce.service;

import br.edu.unifaa.ecommerce.model.Categoria;
import br.edu.unifaa.ecommerce.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import java.util.InputMismatchException;
import java.util.List;
// import java.util.Optional;

@Service
public class CategoriaService {
    
    @Autowired // Pedindo o controle dessa classe para utilização
    private CategoriaRepository categoriaRepository;

    public Categoria adicionar(Categoria categoria){

        return categoriaRepository.adicionar(categoria);
    }

    public List<Categoria> obterTodos(){

        return categoriaRepository.obterTodos();
    }

    public Categoria obterPorId(Long id){

        return categoriaRepository.obterPorId(id);
    }
}
