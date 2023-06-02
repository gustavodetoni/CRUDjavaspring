package com.example.crud.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @GetMapping
    public ResponseEntity getAllProduto() {
        return  ResponseEntity.ok("200");
    }
}
