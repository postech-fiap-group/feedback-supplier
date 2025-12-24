package org.fiap.relatorio.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.fiap.avaliacao.entity.AvaliacaoEntity;
import org.fiap.avaliacao.repository.AvaliacaoRepository;
import org.fiap.relatorio.dto.RelatorioSemanalDTO;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ApplicationScoped
public class RelatorioSemanalService {

    @Inject
    AvaliacaoRepository repository;

    public RelatorioSemanalDTO gerarRelatorio() {

        List<AvaliacaoEntity> avaliacoes = repository.listAll();

        RelatorioSemanalDTO dto = new RelatorioSemanalDTO();

        dto.totalAvaliacoes = (long) avaliacoes.size();

        double media = avaliacoes.stream()
                .mapToInt(AvaliacaoEntity::getNota)
                .average()
                .orElse(0.0);

        dto.mediaNotas = BigDecimal.valueOf(media)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();

        dto.avaliacoesPorDia = avaliacoes.stream()
                .collect(Collectors.groupingBy(
                        a -> a.getDataCriacao().toLocalDate().toString(),
                        Collectors.counting()
                ));

        dto.avaliacoesPorUrgencia = avaliacoes.stream()
                .collect(Collectors.groupingBy(
                        a -> a.isUrgente() ? "URGENTE" : "NORMAL",
                        Collectors.counting()
                ));

        return dto;
    }
}