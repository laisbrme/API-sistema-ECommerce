package br.edu.unifaa.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.unifaa.ecommerce.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}
