package com.example.crud.domain.produto;

import org.antlr.v4.runtime.misc.NotNull;

public record RequestProduto(String nome, @NotNull Integer preço) {

}
