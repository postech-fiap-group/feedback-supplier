package org.fiap.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.fiap.dto.UsuarioDTO;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UsuarioService {

    private final List<UsuarioDTO> usuarios = new ArrayList<>();

    public void criar(UsuarioDTO dto) {
        usuarios.add(dto);
    }

    public List<UsuarioDTO> listar() {
        return usuarios;
    }
}
