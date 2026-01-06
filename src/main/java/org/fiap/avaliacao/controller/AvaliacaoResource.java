package org.fiap.avaliacao.controller;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.fiap.avaliacao.dto.AvaliacaoRequestDTO;
import org.fiap.avaliacao.service.AvaliacaoService;

@Path("/avaliacao")
@Consumes("application/json")
@Produces("application/json")
@RolesAllowed("STUDENT")
public class AvaliacaoResource {

    @Inject
    AvaliacaoService service;

    @POST
    public Response criar(@Valid AvaliacaoRequestDTO dto) {
        return Response.status(Response.Status.CREATED)
                .entity(service.criar(dto))
                .build();
    }

    @GET
    @RolesAllowed("ADMIN")
    public Response listar() {
        return Response.ok(service.listar()).build();
    }
}