package br.edu.unifaa.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
   
    private long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private List<Endereco> enderecos;
    
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
