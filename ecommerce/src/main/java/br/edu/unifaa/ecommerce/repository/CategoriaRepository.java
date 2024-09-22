package br.edu.unifaa.ecommerce.repository;

import br.edu.unifaa.ecommerce.model.Categoria;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;

@Repository
public class CategoriaRepository{
    // Comunicação em memória com o banco de dados.
    private List<Categoria> categorias = new ArrayList<Categoria>();
    private int ultimoId = 0;

    public Categoria adicionar(Categoria categoria){

        ultimoId++;
        categoria.setId(ultimoId);
        categorias.add(categoria);

        return categoria;
    }

    public List<Categoria> obterTodos(){
        
        return categorias;
    }

    public Categoria obterPorId(Long id){

        for(Categoria categoria : categorias){

            if(categoria.getId() == id){

                return categoria;
            }
        }

        return new Categoria();
    }
}
