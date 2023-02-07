package com.food.roots.domain.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "PEDIDO")
@EqualsAndHashCode(of = "id")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SUBTOTAL")
    private BigDecimal subTotal;
    @Column(name = "TAXA_FRETE")
    private BigDecimal taxaFrete;
    @Column(name = "VALOR_TOTAL")
    private BigDecimal valorTotal;
    @Column(name = "DATA_PEDIDO")
    private LocalDateTime dataPedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_STATUS_PEDIDO")
    private StatusPedido statusPedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_FORMA_PAGAMENTO")
    private FormaPagamento formaPagamento;


}
