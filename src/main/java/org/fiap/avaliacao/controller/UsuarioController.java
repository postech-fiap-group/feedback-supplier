package org.fiap.avaliacao.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.fiap.avaliacao.dto.UsuarioDTO;
import org.fiap.avaliacao.entity.UsuarioEntity;
import org.fiap.avaliacao.service.UsuarioService;

import java.util.List;

@Path("/usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioController {

    @Inject
    UsuarioService service;

    @POST
    public void criar(UsuarioDTO dto) {
        service.criar(dto);
    }

    @GET
    public List<UsuarioEntity> listarTodos() {
        return service.listar();
    }
}
