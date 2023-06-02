package com.example.crud.controllers;

import com.example.crud.domain.produto.RepositoryProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
