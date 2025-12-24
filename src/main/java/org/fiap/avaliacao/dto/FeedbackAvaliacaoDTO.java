package org.fiap.avaliacao.dto;

public record FeedbackAvaliacaoDTO(
        String usuarioEmail,
        String comentario,
        int nota
) {}

