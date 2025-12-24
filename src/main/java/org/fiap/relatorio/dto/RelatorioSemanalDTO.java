package org.fiap.relatorio.dto;

import java.util.Map;

public class RelatorioSemanalDTO {

    public Double mediaNotas;
    public Long totalAvaliacoes;
    public Map<String, Long> avaliacoesPorDia;
    public Map<String, Long> avaliacoesPorUrgencia;
}
