package com.example.crud.domain.produto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryProduto extends JpaRepository<Produto, String> {
}
