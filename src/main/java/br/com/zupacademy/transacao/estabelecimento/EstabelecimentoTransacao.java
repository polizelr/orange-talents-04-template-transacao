package br.com.zupacademy.transacao.estabelecimento;

public class EstabelecimentoTransacao {
    private String nome;
    private String cidade;
    private String endereco;

    public EstabelecimentoTransacao(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    @Deprecated
    public EstabelecimentoTransacao() {
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    @Override
    public String toString() {
        return "EstabelecimentoTransacao{" +
                "nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }

    public Estabelecimento converte() {
        return new Estabelecimento(nome, cidade, endereco);
    }
}
