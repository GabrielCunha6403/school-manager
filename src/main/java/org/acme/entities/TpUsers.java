package org.acme.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.acme.dto.TpUsersDto;

@Entity
@Table(
        name = "TP_USERS"
)
public class TpUsers extends PanacheEntityBase {
    @Id
    @Column(name = "cd_tp_user")
    public Long cdTpUser;
    @Column(name = "ds_tp_user")
    public String dsTpUser;

    public TpUsers() {}

    public TpUsers(Long cdTpUser, String dsTpUser) {
        this.cdTpUser = cdTpUser;
        this.dsTpUser = dsTpUser;
    }

    public TpUsers(TpUsersDto dto) {
        this.cdTpUser = dto.cdTpUser();
        this.dsTpUser = dto.dsTpUser();
    }
}
