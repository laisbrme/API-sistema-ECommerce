package br.edu.unifaa.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.unifaa.ecommerce.model.Categoria;

public interface CategoriaRepository extends JpaRepository < Categoria, Long>{
    
}
