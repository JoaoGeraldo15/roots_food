package com.food.roots.domain.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "STATUS_ATIVO")
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class StatusAtivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "VALOR", nullable = false)
    private Boolean valor;

    @Column(name = "DESCRICAO")
    private String descricao;

    public StatusAtivo(Long id) {
        this.id = id;
    }
}
