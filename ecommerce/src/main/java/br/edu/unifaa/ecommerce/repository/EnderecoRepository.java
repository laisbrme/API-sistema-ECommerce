package br.edu.unifaa.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unifaa.ecommerce.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    
}
