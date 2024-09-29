package br.edu.unifaa.ecommerce.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "idProduto")
    private long id;
    
    @Column (nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private double valor;
    
    @Column(nullable = false)
    private int quantidadeEstoque;
    
    @Column(nullable = false)
    private Date dataCadastro;
    
    // @JsonBackReference
    private List<Categoria> categorias;
    
    @Column (nullable = false, columnDefinition = "TEXT")
    private String observacao;

    // Construtores
    public Produto() {
    }
    
    public Produto(String nome, double valor, int quantidadeEstoque, Date dataCadastro, String observacao) {
        this.nome = nome;
        this.valor = valor;
        this.quantidadeEstoque = quantidadeEstoque;
        this.dataCadastro = dataCadastro;
        this.observacao = observacao;

        this.categorias = new ArrayList<Categoria>();
    }

    public Produto(String nome, double valor, int quantidadeEstoque, Date dataCadastro, List<Categoria> categorias,
            String observacao) {
        this.nome = nome;
        this.valor = valor;
        this.quantidadeEstoque = quantidadeEstoque;
        this.dataCadastro = dataCadastro;
        this.categorias = categorias;
        this.observacao = observacao;
    }

    // Getters e Setters
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
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }
    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
    public Date getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    public List<Categoria> getCategorias() {
        return categorias;
    }
    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }    
}
