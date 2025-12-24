package org.fiap.avaliacao.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.fiap.avaliacao.entity.UsuarioEntity;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<UsuarioEntity> {
}
