package org.acme.dto;

import org.acme.entities.TpUsers;

public record TpUsersDto(Long cdTpUser, String dsTpUser) {
    public TpUsersDto(TpUsers tpUser) {
        this(tpUser.cdTpUser, tpUser.dsTpUser);
    }
}
