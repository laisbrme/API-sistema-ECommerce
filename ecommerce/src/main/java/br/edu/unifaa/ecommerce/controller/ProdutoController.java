package br.edu.unifaa.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unifaa.ecommerce.model.Produto;
import br.edu.unifaa.ecommerce.service.ProdutoService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity <List<Produto>> obterTodos(){

        return ResponseEntity.ok (produtoService.obterTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity <Optional <Produto>> obterPorId(@PathVariable Long id){

        return ResponseEntity.ok (produtoService.obterPorId(id));
    }

    @PostMapping 
    public ResponseEntity <Produto> adicionar(@RequestBody Produto produto){
        var produtoCriado = produtoService.adicionar (produto);
        return new ResponseEntity <> (produtoCriado, HttpStatus.CREATED);
    }

    @PutMapping ("/{id}")
    public ResponseEntity <Produto> atualizar( @PathVariable long id, @RequestBody Produto produto){

        return ResponseEntity.ok (produtoService.atualizar(id, produto));
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<?> deletar (@PathVariable Long id){

       produtoService.deletar(id);

       return new ResponseEntity<> (HttpStatus.NO_CONTENT);
    }

}
