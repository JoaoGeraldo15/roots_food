package com.food.roots.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class RestauranteDTO {

    private Long id;

    private String nome;

    private BigDecimal taxaEntrega;

    private Boolean ativo;

    private Boolean aberto;

    private LocalDateTime dataCadastro;

    private LocalDateTime dataAtualizacao;

    private CozinhaDTO cozinha;
}

