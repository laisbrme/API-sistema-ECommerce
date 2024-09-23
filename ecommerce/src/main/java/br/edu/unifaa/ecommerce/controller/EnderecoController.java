package br.edu.unifaa.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unifaa.ecommerce.model.Categoria;
import br.edu.unifaa.ecommerce.model.Endereco;
import br.edu.unifaa.ecommerce.service.CategoriaService;
import br.edu.unifaa.ecommerce.service.EnderecoService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public List<Endereco> obterTodos(){

        return enderecoService.obterTodos();
    }

    @GetMapping("/{id}")
    public Endereco obterPorId(@PathVariable Long id){

        return enderecoService.obterPorId(id);
    }

    @PostMapping 
    public Endereco adicionar(@RequestBody Endereco endereco){

        return enderecoService.adicionar(endereco);
    }
}
