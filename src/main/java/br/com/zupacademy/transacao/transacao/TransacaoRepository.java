package br.com.zupacademy.transacao.transacao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao,String> {
    Page<Transacao> findByCartaoId(String cartaoId, Pageable pageable);
}
