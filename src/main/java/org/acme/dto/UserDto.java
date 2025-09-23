package org.acme.dto;

import org.acme.entities.TpUsers;
import org.acme.entities.User;

public record UserDto(Long cdUser, String nmUser, TpUsers tpUser, String cpf) {
    public UserDto(User user) {
        this(user.cdUser, user.nmUser, user.tpUser, user.cpf);
    }
}
