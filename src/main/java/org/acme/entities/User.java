package org.acme.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.acme.dto.UserDto;

@Entity
@NoArgsConstructor
@Table(name = "USERS")
public class User extends PanacheEntityBase {
    @Id
    @GeneratedValue
    @Column(name = "CD_USER")
    public Long cdUser;
    @Column(name = "NM_USER")
    public String nmUser;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TP_USER")
    public TpUsers tpUser;
    @Column(name = "cpf")
    public String cpf;

    public User() {}

    public User(UserDto dto) {
        this.nmUser = dto.nmUser;
        this.tpUser = dto.tpUser;
        this.cpf = dto.cpf;
    }
}
