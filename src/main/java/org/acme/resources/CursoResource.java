package org.acme.resources;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.acme.dto.CursoDto;
import org.acme.services.CursoService;

@Path("/cursos")
public class CursoResource {

    @Inject
    private CursoService cursoService;

    @GET
    @Path("list")
    @RolesAllowed({"coordenador", "professor", "aluno"})
    public Response listCursos() {
        return Response.ok(cursoService.listCursos()).build();
    }

    @GET
    @Path("listProfessoresFromCurso")
    @RolesAllowed({"coordenador"})
    public Response listProfessoresFromCurso(@QueryParam("cdCurso") Long cdCurso) {
        return Response.ok(cursoService.listProfessoresFromCurso(cdCurso)).build();
    }

    @GET
    @Path("listCoordenadores")
    @RolesAllowed({"coordenador"})
    public Response listCoordenadores() {
        return Response.ok(cursoService.listCoordenadores()).build();
    }

    @GET
    @RolesAllowed({"coordenador"})
    public Response getCurso(@QueryParam("cdCurso") Long cdCurso) {
        return Response.ok(cursoService.getCurso(cdCurso)).build();
    }

    @POST
    @RolesAllowed({"coordenador"})
    public Response postCurso(CursoDto dto) {
        return Response.ok(cursoService.postCurso(dto)).build();
    }

    @PUT
    @RolesAllowed({"coordenador"})
    public Response editCurso(CursoDto dto) {
        return Response.ok(cursoService.editCurso(dto)).build();
    }

    @DELETE
    @RolesAllowed({"coordenador"})
    public Response deleteCurso(@QueryParam("cdCurso") Long cdCurso) {
        cursoService.deleteCurso(cdCurso);
        return Response.ok().build();
    }

}
