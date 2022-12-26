package com.food.roots.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "RESTAURANTE")
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String nome;

    @Column(name = "TAXA_ENTREGA")
    private BigDecimal taxaEntrega;

    @Column(name = "ID_STATUS_ATIVO")
    private Boolean ativo;

    @Column(name = "ABERTO")
    private Boolean aberto;

    @CreationTimestamp
    @Column(name = "DATA_REGISTRO")
    private LocalDateTime dataCadastro;

    @UpdateTimestamp
    @Column(name = "DATA_ATUALIZACAO")
    private LocalDateTime dataAtualizacao;

    @ManyToOne
    @JoinColumn(name = "ID_COZINHA", nullable = false)
    private Cozinha cozinha;

    @ManyToMany
    @JoinTable(name = "RESTAURANTE_FORMA_PAGAMENTO", joinColumns = @JoinColumn(name = "ID_RESTAURANTE"), inverseJoinColumns = @JoinColumn(name = "ID_FORMA_PAGAMENTO"))
    private List<FormaPagamento> formasPagamento = new ArrayList<>();

    @OneToMany(mappedBy = "restaurante")
    private List<Produto> produtos = new ArrayList<>();

}
