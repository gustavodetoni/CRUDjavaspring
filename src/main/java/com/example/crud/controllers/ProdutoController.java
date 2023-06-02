package com.example.crud.controllers;

import com.example.crud.domain.produto.Produto;
import com.example.crud.domain.produto.RepositoryProduto;
import com.example.crud.domain.produto.RequestProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity postProduto(@RequestBody @Validated RequestProduto data) {
        Produto newProduto = new Produto(data);
        repository.save(newProduto);
        return ResponseEntity.ok().build();
    }
}
