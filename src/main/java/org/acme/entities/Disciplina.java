package org.acme.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.acme.dto.DisciplinaDto;
import org.acme.dto.UserDto;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "DISCIPLINAS")
public class Disciplina extends PanacheEntityBase {
    @Id
    @GeneratedValue
    @Column(name = "CD_DISCIPLINA")
    public Long cdDisciplina;
    @Column(name = "NM_DISCIPLINA")
    public String nmDisciplina;
    @Column(name = "SEMESTRE")
    public Long semestre;
    @Column(name = "NR_CREDITOS")
    public Long nrCreditos;
    @ManyToMany
    @JoinTable(
            name = "disciplina_professor", // nome da tabela associativa
            joinColumns = @JoinColumn(name = "disciplina_id"), // chave de disciplina
            inverseJoinColumns = @JoinColumn(name = "professor_id") // chave de professor
    )
    public List<User> professores;

    public Disciplina() {}

    public Disciplina(DisciplinaDto dto) {
        this.cdDisciplina = dto.getCdDisciplina();
        this.nmDisciplina = dto.getNmDisciplina();
        this.semestre = dto.getSemestre();
        this.nrCreditos = dto.getNrCreditos();
        this.professores = dto.getProfessores().stream()
                .map(user -> (User) User.findById(user.getCdUser()))
                .collect(Collectors.toList());
    }
}
