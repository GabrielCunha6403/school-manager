package org.acme.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.acme.dto.DisciplinaDto;
import org.acme.dto.UserDto;
import org.acme.services.DisciplinaService;
import org.acme.services.UserService;

@Path("/disciplinas")
public class DisciplinaResource {

    @Inject
    private DisciplinaService disciplinaService;

    @Inject
    private UserService userService;

    @GET
    @Path("listProfessores")
    public Response listProfessores() {
        return Response.ok(userService.listProfessores()).build();
    }

    @GET
    public Response getProfessor(@QueryParam("cdDisciplina") Long cdDisciplina) {
        return Response.ok(disciplinaService.getDisciplina(cdDisciplina)).build();
    }

    @GET
    @Path("list")
    public Response listDisciplinas(@QueryParam("cdCurso") Long cdCurso) {
        return Response.ok(disciplinaService.listDisciplina(cdCurso)).build();
    }

    @POST
    public Response postDisciplina(DisciplinaDto dto) {
        return Response.ok(disciplinaService.postDisciplina(dto)).build();
    }

    @PUT
    public Response editDisciplina(DisciplinaDto dto) {
        return Response.ok(disciplinaService.editDisciplina(dto)).build();
    }

    @DELETE
    public Response deleteDisciplina(@QueryParam("cdDisciplina") Long cdDisciplina) {
        disciplinaService.deleteDisciplina(cdDisciplina);
        return Response.ok().build();
    }

}
