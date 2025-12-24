package org.fiap.avaliacao.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.fiap.avaliacao.entity.AvaliacaoEntity;

@ApplicationScoped
public class AvaliacaoRepository implements PanacheRepository<AvaliacaoEntity> {
}
