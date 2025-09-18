package org.acme.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.acme.dto.TpUsersDto;
import org.acme.entities.TpUsers;

import java.util.List;
import java.util.stream.Collectors;

@Path("/users")
public class UsersResource {

    @GET
    public List<TpUsersDto> getTpUsers() {
        List<TpUsers> usuarios = TpUsers.listAll(); // Panache
        return usuarios.stream()
                .map(TpUsersDto::new)
                .collect(Collectors.toList());
    }
}
