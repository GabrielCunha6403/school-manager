package org.acme.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.acme.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

@Entity
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
    @ManyToMany(mappedBy = "professores")
    public List<Disciplina> disciplinas = new ArrayList<>();

    public User() {}

    public User(UserDto dto) {
        this.cdUser = dto.cdUser();
        this.nmUser = dto.nmUser();
        this.tpUser = dto.tpUser();
        this.cpf = dto.cpf();
    }
}
