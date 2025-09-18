package org.acme.dto;

import org.acme.entities.TpUsers;
import org.acme.entities.User;

public class UserDto {
    public Long cdUser;
    public String nmUser;
    public TpUsers tpUser;
    public String cpf;

    public UserDto() {}

    public UserDto(User user) {
        this.cdUser = user.cdUser;
        this.nmUser = user.nmUser;
        this.tpUser = user.tpUser;
        this.cpf = user.cpf;
    }
}
