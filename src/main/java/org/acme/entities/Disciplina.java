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
            name = "disciplina_professor",
            joinColumns = @JoinColumn(name = "disciplina_id"),
            inverseJoinColumns = @JoinColumn(name = "professor_id")
    )
    public List<User> professores;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CD_CURSO", nullable = false)
    public Curso curso;

    public Disciplina() {}

    public Disciplina(DisciplinaDto dto) {
        this.cdDisciplina = dto.cdDisciplina();
        this.nmDisciplina = dto.nmDisciplina();
        this.semestre = dto.semestre();
        this.nrCreditos = dto.nrCreditos();
        this.professores = dto.professores() != null ? dto.professores().stream()
                .map(user -> (User) User.findById(user.cdUser()))
                .toList() : null;
        this.curso = Curso.findById(dto.cdCurso());
    }
}
