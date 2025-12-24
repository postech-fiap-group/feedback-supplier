package org.fiap.avaliacao.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.fiap.avaliacao.dto.AvaliacaoRequestDTO;
import org.fiap.avaliacao.entity.AvaliacaoEntity;
import org.fiap.avaliacao.repository.AvaliacaoRepository;
import org.fiap.notificacao.dto.NotificacaoDTO;
import org.fiap.notificacao.service.NotificacaoService;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class AvaliacaoService {

    @Inject
    AvaliacaoRepository repository;

    @Inject
    NotificacaoService notificacaoService;

    @Transactional
    public AvaliacaoEntity criar(AvaliacaoRequestDTO dto) {

        AvaliacaoEntity avaliacao = new AvaliacaoEntity();
        avaliacao.setDescricao(dto.descricao);
        avaliacao.setNota(dto.nota);

        repository.persist(avaliacao);

        if (avaliacao.isUrgente()) {

            NotificacaoDTO notificacao = new NotificacaoDTO();
            notificacao.descricao = avaliacao.getDescricao();
            notificacao.urgente = avaliacao.isUrgente();
            notificacao.dataEnvio = LocalDateTime.now();

            notificacaoService.enviar(notificacao);
        }

        return avaliacao;
    }

    public List<AvaliacaoEntity> listar() {
        return repository.listAll();
    }
}