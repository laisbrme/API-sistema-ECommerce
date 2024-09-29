package br.edu.unifaa.ecommerce.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;

//many to one
@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "idCategoria")
    private long id;
    
    @Column (nullable = false)
    private String nome;
    
    @Column (nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @ManyToOne
    @JoinTable(
        name = "categoria_produto",
        joinColumns = @JoinColumn(name = "idProduto"),
        inverseJoinColumns = @JoinColumn(name = "idCategoria")
    )  // id da categoria no relacionamento de um para muitos
    private List<Produto> produto;


    // Construtores
    public Categoria() {
    }
    
    public Categoria(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
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
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public List<Produto> getProduto() {
        return produto;
    }
    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }
}
