package org.acme.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.acme.entities.TpUsers;

@Getter
@Setter
@NoArgsConstructor
public class TpUsersDto {
    public Long cdTpUser;
    public String dsTpUser;

    public TpUsersDto(TpUsers tpUser) {
        this.cdTpUser = tpUser.cdTpUser;
        this.dsTpUser = tpUser.dsTpUser;
    }
}
