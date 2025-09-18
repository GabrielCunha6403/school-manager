package org.acme.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.acme.entities.TpUsers;

@Getter
@Setter
@NoArgsConstructor
public class TpUsersDto {
    public String dsTpUser;

    public TpUsersDto(TpUsers tpUser) {
        this.dsTpUser = tpUser.dsTpUser;
    }
}
