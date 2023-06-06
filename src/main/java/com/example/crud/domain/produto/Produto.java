package com.example.crud.domain.produto;

import jakarta.persistence.*;
import lombok.*;

@Table(name="produto")
@Entity(name="produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String nome;
    private Integer preço;

    public Produto(RequestProduto requestProduto) {
        this.nome = requestProduto.nome();
        this.preço = requestProduto.preço();
    }

}
