package org.fiap.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.fiap.dto.UsuarioDTO;
import org.fiap.service.UsuarioService;

import java.util.List;

@Path("/usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class UsuarioController {

    @Inject
    UsuarioService service;

    @POST
    public void criar(UsuarioDTO dto) {
        service.criar(dto);
    }

    @GET
    public List<UsuarioDTO> listarTodos() {
        return service.listar();
    }
}
