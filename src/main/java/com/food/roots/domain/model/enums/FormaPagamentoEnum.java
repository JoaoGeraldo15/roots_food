package com.food.roots.domain.model.enums;

import com.food.roots.domain.model.entity.FormaPagamento;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;

@Getter
@AllArgsConstructor
public enum FormaPagamentoEnum {
    CARTAO_DEBITO(1L, "Cartão de Débito"),
    CARTAO_CREDITO(2L, "Cartão de Crédito"),
    DINHEIRO(3L, "Dinheiro"),
    PIX(4L, "Pix"),
    PAGAMENTO_ONLINE(5L, "Pagamento Online");

    private Long id;
    private String descricao;

    public static HashMap<Long, String> CACHE = new HashMap<>();

    static {
        for (FormaPagamentoEnum formaPagamentoEnum: FormaPagamentoEnum.values()) {
            CACHE.put(formaPagamentoEnum.getId(), formaPagamentoEnum.getDescricao());
        }
    }

    public FormaPagamento obterFormaPagamento() {
        return new FormaPagamento(this.getId(), CACHE.get(this.getId()));
    }

}
