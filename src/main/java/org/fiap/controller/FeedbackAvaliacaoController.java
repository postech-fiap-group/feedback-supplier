package org.fiap.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.fiap.dto.FeedbackAvaliacaoDTO;
import org.fiap.service.FeedbackAvaliacaoService;

import java.util.List;

@Path("/feedbacks")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class FeedbackAvaliacaoController {

    @Inject
    FeedbackAvaliacaoService service;

    @POST
    public void criar(FeedbackAvaliacaoDTO dto) {
        service.criar(dto);
    }

    @GET
    public List<FeedbackAvaliacaoDTO> listarTodos() {
        return service.listar();
    }
}
