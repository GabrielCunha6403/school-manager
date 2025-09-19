package org.acme.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.acme.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

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
    @ManyToMany(mappedBy = "professores")
    public List<Disciplina> disciplinas = new ArrayList<>();

    public User() {}

    public User(UserDto dto) {
        this.nmUser = dto.getNmUser();
        this.tpUser = dto.getTpUser();
        this.cpf = dto.getCpf();
    }
}
