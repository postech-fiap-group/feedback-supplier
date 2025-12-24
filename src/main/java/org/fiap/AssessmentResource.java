package org.fiap;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.fiap.avaliacao.entity.Assessment;
import org.fiap.avaliacao.service.AssesmentService;

import java.util.List;


@Path("/assessment")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AssessmentResource {

    @Inject
    AssesmentService assesmentService;

    @GET
    public List<Assessment> listarTodas() {
        return assesmentService.listarTodas();
    }

   /* @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        return assesmentService.buscarPorId(id)
                .map(Response::ok)
                .orElse(Response.status(Response.Status.NOT_FOUND))
                .build();
    }

    @POST
    public Response criar(Assessment noticia) {
        return Response.status(Response.Status.CREATED)
                .entity(assesmentService.salvar(noticia))
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") Long id, Assessment noticia) {
        if (assesmentService.buscarPorId(id).isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(assesmentService.atualizar(id, noticia)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        if (assesmentService.deletar(id)) {
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }*/

    
}