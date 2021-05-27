package br.com.zupacademy.transacao.transacao;

import br.com.zupacademy.transacao.cartao.Cartao;
import br.com.zupacademy.transacao.estabelecimento.Estabelecimento;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {
    @Id
    private String id;

    @Column(nullable = false)
    private BigDecimal valor;

    @ManyToOne(optional = false)
    private Estabelecimento estabelecimento;

    @ManyToOne(optional = false)
    private Cartao cartao;

    @Column(nullable = false)
    private LocalDateTime efetivadaEm;

    public Transacao(String id, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    @Deprecated
    public Transacao() {
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
