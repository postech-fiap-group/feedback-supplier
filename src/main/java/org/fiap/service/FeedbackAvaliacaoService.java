package org.fiap.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.fiap.dto.FeedbackAvaliacaoDTO;
import org.fiap.messaging.FeedbackProducer;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class FeedbackAvaliacaoService {

    @Inject
    FeedbackProducer producer;

    private final List<FeedbackAvaliacaoDTO> feedbacks = new ArrayList<>();

    public void criar(FeedbackAvaliacaoDTO dto) {
        feedbacks.add(dto);        // GET ALL
        producer.enviar(dto);      // RABBIT MQ
    }

    public List<FeedbackAvaliacaoDTO> listar() {
        return feedbacks;
    }
}
