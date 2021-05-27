package br.com.zupacademy.transacao.cartao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cartao {
    @Id
    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String email;

    public Cartao(String id, String email) {
        this.id = id;
        this.email = email;
    }

    @Deprecated
    public Cartao() {
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void getCartao(String id) {
    }
}
