package org.fiap.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.fiap.dto.UsuarioDTO;
import org.fiap.model.UsuarioEntity;
import org.fiap.repository.UsuarioRepository;

import java.util.List;

@ApplicationScoped
public class UsuarioService {

    @Inject
    UsuarioRepository repository;

    @Transactional
    public void criar(UsuarioDTO dto) {
        UsuarioEntity entity = new UsuarioEntity();
        entity.nome = dto.nome();
        entity.email = dto.email();

        repository.persist(entity);
    }

    public List<UsuarioEntity> listar() {
        return repository.listAll();
    }
}
