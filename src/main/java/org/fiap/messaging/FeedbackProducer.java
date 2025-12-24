package org.fiap.messaging;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.fiap.avaliacao.dto.FeedbackAvaliacaoDTO;

@ApplicationScoped
public class FeedbackProducer {

    @Channel("feedback-out")
    Emitter<FeedbackAvaliacaoDTO> emitter;

    public void enviar(FeedbackAvaliacaoDTO feedback) {
        emitter.send(feedback);
    }
}
