package org.fiap.notificacao.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.fiap.notificacao.dto.NotificacaoDTO;

@ApplicationScoped
public class NotificacaoService {

    @Inject
    @Channel("feedback-out")
    Emitter<NotificacaoDTO> emitter;

    public void enviar(NotificacaoDTO dto) {
        emitter.send(dto);
    }
}
