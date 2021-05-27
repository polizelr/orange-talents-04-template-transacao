package br.com.zupacademy.transacao.cartao;

public class CartaoResponse {
    private String id;
    private String email;

    public CartaoResponse(Cartao cartao) {
        this.id = cartao.getId();
        this.email = cartao.getEmail();
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
