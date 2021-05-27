package br.com.zupacademy.transacao.transacao;

import br.com.zupacademy.transacao.cartao.Cartao;
import br.com.zupacademy.transacao.cartao.CartaoRepository;
import br.com.zupacademy.transacao.utils.TransactionExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ListenerTransacao {
    @Autowired
    CartaoRepository cartaoRepository;

    @Autowired
    TransactionExecutor executor;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(EventoTransacao eventoTransacao) {
        try{
            Cartao cartao;
            Optional<Cartao> possivelCartao = cartaoRepository.findById(eventoTransacao.getCartao().getId());
            if(possivelCartao.isPresent()){
                cartao = possivelCartao.get();
            } else{
                cartao = eventoTransacao.getCartao().converte();
                executor.saveAndCommit(cartao);
            }
            Transacao transacao = eventoTransacao.converte(cartao);
            executor.saveAndCommit(transacao.getEstabelecimento());
            executor.saveAndCommit(transacao);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
