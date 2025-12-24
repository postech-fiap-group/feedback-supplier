package org.fiap.relatorio.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.fiap.relatorio.service.RelatorioSemanalService;

@Path("/relatorio")
@Produces(MediaType.APPLICATION_JSON)
public class RelatorioResource {

    @Inject
    RelatorioSemanalService service;

    @GET
    @Path("/semanal")
    public Response gerar() {
        return Response.ok(service.gerarRelatorio()).build();
    }
}