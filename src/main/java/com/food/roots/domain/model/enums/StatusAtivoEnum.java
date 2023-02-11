package com.food.roots.domain.model.enums;

import com.food.roots.domain.model.entity.StatusAtivo;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;

@Getter
@AllArgsConstructor
public enum StatusAtivoEnum {
    ATIVO(1L, Boolean.TRUE, "ATIVO"),
    INATIVO(2L,Boolean.FALSE,  "INATIVO");
    private Long id;
    private Boolean valor;
    private String descricao;
    public static HashMap<Long, String> CACHE = new HashMap<>();
    static {
        for (StatusAtivoEnum statusAtivoEnum: StatusAtivoEnum.values()) {
            CACHE.put(statusAtivoEnum.getId(), statusAtivoEnum.getDescricao());
        }
    }
    public StatusAtivo obterStatusAtivo() {return new StatusAtivo(this.getId());}
}
