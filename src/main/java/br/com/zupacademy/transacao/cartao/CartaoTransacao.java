package br.com.zupacademy.transacao.cartao;

public class CartaoTransacao {
    private String id;
    private String email;

    public CartaoTransacao(String id, String email) {
        this.id = id;
        this.email = email;
    }

    @Deprecated
    public CartaoTransacao() {
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "CartaoTransacao{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Cartao converte() {
        return new Cartao(id, email);
    }


}
