package com.food.roots.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class CozinhaDTO {
    private Long id;

    private String nome;

    public CozinhaDTO(String nome) {
        this.nome = nome;
    }

}

