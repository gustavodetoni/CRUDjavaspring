package com.example.crud.controllers;

import com.example.crud.domain.produto.Produto;
import com.example.crud.domain.produto.RepositoryProduto;
import com.example.crud.domain.produto.RequestProduto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private RepositoryProduto repository;
    @GetMapping
    public ResponseEntity getAllProduto() {
        var allProduto = repository.findAll();
        return  ResponseEntity.ok(allProduto);
    }

    @PostMapping(value = "/produto")
    public ResponseEntity postProduto(@RequestBody @Validated RequestProduto data) {
        Produto newProduto = new Produto(data);
        repository.save(newProduto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/produto/{id}")
    public ResponseEntity putProduto(@PathVariable(value = "id") long id, @RequestBody @Validated RequestProduto data) {
        Optional<Produto> optionalProdutos = repository.findById(data.id());
        if (optionalProdutos.isPresent()) {
            Produto newProduto = new Produto(data);
            newProduto.setNome(data.nome());
            newProduto.setPreço(data.preço());
            return ResponseEntity.ok(newProduto);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @DeleteMapping("/produto/{id}")
    public ResponseEntity<Objects> deleteProduto(@PathVariable(value = "id") String id) {
        Optional<Produto> optionalProduto = repository.findById(id);
        if(optionalProduto.isPresent()) {
            repository.delete(optionalProduto.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            throw new EntityNotFoundException();
        }
    }
}
