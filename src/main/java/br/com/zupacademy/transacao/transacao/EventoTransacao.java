package br.com.zupacademy.transacao.transacao;

import br.com.zupacademy.transacao.cartao.Cartao;
import br.com.zupacademy.transacao.cartao.CartaoTransacao;
import br.com.zupacademy.transacao.estabelecimento.Estabelecimento;
import br.com.zupacademy.transacao.estabelecimento.EstabelecimentoTransacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EventoTransacao {
    private String id;
    private BigDecimal valor;
    private EstabelecimentoTransacao estabelecimento;
    private CartaoTransacao cartao;
    private LocalDateTime efetivadaEm;

    public EventoTransacao(String id, BigDecimal valor, EstabelecimentoTransacao estabelecimento, CartaoTransacao cartao, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    @Deprecated
    public EventoTransacao() {
    }


    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoTransacao getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoTransacao getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    @Override
    public String toString() {
        return "EventoDeTransacao{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                ", estabelecimento=" + estabelecimento +
                ", cartao=" + cartao +
                ", efetivadaEm=" + efetivadaEm +
                '}';
    }

    public Transacao converte(Cartao cartao) {

        return new Transacao(
                id,
                valor,
                estabelecimento.converte(),
                cartao,
                efetivadaEm
        );
    }
}
