package com.food.roots.domain.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ITEM_PEDIDO")
@EqualsAndHashCode(of = "id")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "QUANTIDADE")
    private Integer quantidade;
    @Column(name = "PRECO_UNITARIO")
    private BigDecimal precoUnitario;
    @Column(name = "PRECO_TOTAL")
    private BigDecimal precoTotal;
    @Column(name = "OBSERVACAO")
    private String observacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PEDIDO")
    private Pedido pedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PRODUTO")
    private Produto produto;


}
