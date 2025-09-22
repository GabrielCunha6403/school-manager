package org.acme.resources;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import org.acme.dto.SemestrePutDto;
import org.acme.services.SemestreService;

import java.util.List;

@Path("/semestres")
public class SemestreResource {

    @Inject
    private SemestreService semestreService;

    @GET
    @RolesAllowed({"coordenador", "professor", "aluno"})
    public Response listSemestres(@QueryParam("cdCurso") Long cdCurso) {
        return Response.ok(semestreService.listarPorCurso(cdCurso)).build();
    }

    @PUT
    @RolesAllowed({"coordenador"})
    public Response updateMatrizCurricular(@QueryParam("cdCurso") Long cdCurso, List<SemestrePutDto> list) {
        return Response.ok(semestreService.updateMatrizCurricular(list, cdCurso)).build();
    }

}
