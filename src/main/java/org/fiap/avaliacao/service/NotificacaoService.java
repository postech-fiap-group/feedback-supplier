package org.fiap.notificacao.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.fiap.avaliacao.entity.AvaliacaoEntity;

import java.time.LocalDateTime;
import java.util.Map;

@ApplicationScoped
public class NotificacaoService {

    @Channel("feedback-out")
    Emitter<Map<String, Object>> emitter;

    public void enviarNotificacao(AvaliacaoEntity avaliacao) {

        Map<String, Object> evento = Map.of(
                "descricao", avaliacao.getDescricao(),
                "urgente", true,
                "dataEnvio", LocalDateTime.now().toString()
        );

        emitter.send(evento);
    }
}
