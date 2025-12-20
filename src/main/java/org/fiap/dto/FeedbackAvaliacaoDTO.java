package org.fiap.dto;

public record FeedbackAvaliacaoDTO(
        String usuarioEmail,
        String comentario,
        int nota
) {}

