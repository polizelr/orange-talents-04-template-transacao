package br.com.zupacademy.transacao.transacao;

import br.com.zupacademy.transacao.cartao.Cartao;
import br.com.zupacademy.transacao.cartao.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/transacao")
public class TransacaoController {

    @Autowired
    TransacaoRepository transacaoRepository;

    @Autowired
    CartaoRepository cartaoRepository;

    @GetMapping("/{cartaoId}")
    public ResponseEntity<?> obtemTransacoesRecentes(@PathVariable("cartaoId") String cartaoId){
        Optional<Cartao> cartao = cartaoRepository.findById(cartaoId);
        if(cartao.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Pageable pageable = PageRequest.of(0, 10, Sort.Direction.DESC, "efetivadaEm");
        Page<Transacao> possiveisTransacoes = transacaoRepository.findByCartaoId(cartaoId.toString(), pageable);

        Page<TransacaoResponse> transacoes = TransacaoResponse.converter(possiveisTransacoes);
        return ResponseEntity.ok().body(transacoes);
    }

}
