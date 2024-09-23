package br.edu.unifaa.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unifaa.ecommerce.model.Categoria;
import br.edu.unifaa.ecommerce.service.CategoriaService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> obterTodos(){

        return categoriaService.obterTodos();
    }

    @GetMapping("/{id}")
    public Categoria obterPorId(@PathVariable Long id){

        return categoriaService.obterPorId(id);
    }

    @PostMapping 
    public Categoria adicionar(@RequestBody Categoria categoria){

        return categoriaService.adicionar(categoria);
    }
}
