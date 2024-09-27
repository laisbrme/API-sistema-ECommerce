package br.edu.unifaa.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCliente")
    private long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false, unique = true)
    private String email;
    private String telefone;
    
    @OneToMany
    @JoinTable(
        name = "cliente_endereco",
        joinColumns = @JoinColumn(name = "idCliente"),
        inverseJoinColumns = @JoinColumn(name = "idEndereco")  // InverseJoinColumns relaciona a coluna idEndereco na entidade Endereco com a coluna idCliente na entidade Cliente
    )  // OneToMany com a entidade Endereco, relacionada com a coluna idCliente na entidade Cliente
    private List<Endereco> enderecos; // Many
    
    // Construtores
    public Cliente() {
    }

    public Cliente(String nome, String cpf, String email, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;

        this.enderecos = new ArrayList<Endereco>();
    }

    public Cliente(String nome, String cpf, String email, String telefone, List<Endereco> enderecos) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.enderecos = enderecos;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public List<Endereco> getEnderecos() {
        return enderecos;
    }
    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
