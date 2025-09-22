package org.acme.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(
        name = "TP_USERS"
)
public class TpUsers extends PanacheEntityBase {
    @Id
    @Column(name = "cd_tp_user")
    public Long cdTpUser;
    @Column(name = "ds_tp_user")
    public String dsTpUser;

    public TpUsers(Long cdTpUser, String dsTpUser) {
        this.cdTpUser = cdTpUser;
        this.dsTpUser = dsTpUser;
    }
}
