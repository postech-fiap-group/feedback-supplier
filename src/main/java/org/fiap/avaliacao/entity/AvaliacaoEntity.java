package org.fiap.avaliacao.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "avaliacoes")
public class AvaliacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private int nota;

    private boolean urgente;

    private LocalDateTime dataCriacao;

    @PrePersist
    public void prePersist() {
        this.dataCriacao = LocalDateTime.now();
        this.urgente = this.nota <= 3;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public boolean isUrgente() {
        return urgente;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}
