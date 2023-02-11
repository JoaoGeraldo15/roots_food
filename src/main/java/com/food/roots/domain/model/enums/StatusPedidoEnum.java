package com.food.roots.domain.model.enums;

import com.food.roots.domain.model.entity.StatusPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;

@Getter
@AllArgsConstructor
public enum StatusPedidoEnum {
    REALIZADO(1L, "Realizado"),
    CONFIRMADO(2L, "Confirmado"),
    PRONTO(3L, "Pronto"),
    ENTREGUE(4L, "Entregue");

    private Long id;
    private String descricao;

    public static HashMap<Long, String> CACHE = new HashMap<>();

    static {
        for (StatusPedidoEnum statusPedidoEnum: StatusPedidoEnum.values()) {
            CACHE.put(statusPedidoEnum.getId(), statusPedidoEnum.getDescricao());
        }
    }

    public StatusPedido obterStatusPedido() {
        return new StatusPedido(this.getId(), CACHE.get(this.getId()));
    }

}
