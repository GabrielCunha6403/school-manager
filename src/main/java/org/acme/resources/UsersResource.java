package org.acme.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.acme.dto.UserDto;
import org.acme.services.UserService;

import java.util.List;

@Path("/users")
public class UsersResource {

    @Inject
    private UserService userService;

    @GET
    public Response listUsers() {
        return Response.ok(userService.listUsers()).build();
    }

    @GET
    @Path("find")
    public Response getUser(@QueryParam("cdUser") Long cdUser) {
        return Response.ok(userService.getUser(cdUser)).build();
    }

    @POST
    public Response postUser(UserDto dto) {
        return Response.ok(userService.postUser(dto)).build();
    }

    @GET
    @Path("/listTpUsers")
    public Response listTpUsers() {
        return Response.ok(userService.listTpUsers()).build();
    }

    @PUT
    public Response editUser(UserDto dto) {
        return Response.ok(userService.editUser(dto)).build();
    }

    @DELETE
    public Response deleteUser(@QueryParam("cdUser") Long cdUser) {
        userService.deleteUser(cdUser);
        return Response.ok().build();
    }
}
