package br.edu.unifaa.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unifaa.ecommerce.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
