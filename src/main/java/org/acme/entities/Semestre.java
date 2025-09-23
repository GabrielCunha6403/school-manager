package org.acme.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.acme.dto.DisciplinaDto;
import org.acme.dto.SemestreDto;
import org.acme.dto.SemestrePutDto;

import java.util.List;

@Entity
@Table(name = "SEMESTRES")
public class Semestre extends PanacheEntityBase {

    @EmbeddedId
    private SemestreId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CD_CURSO", nullable = false, insertable = false, updatable = false)
    public Curso curso;

    @Column(name = "SEMESTRE", insertable = false, updatable = false)
    public Long semestre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CD_DISCIPLINA", nullable = false, insertable = false, updatable = false)
    public Disciplina disciplina;

    public Semestre(Curso curso, Long semestre, Disciplina disciplina) {
        this.id = new SemestreId(curso.cdCurso, semestre, disciplina.cdDisciplina);
        this.curso = curso;
        this.semestre = semestre;
        this.disciplina = disciplina;
    }

    public Semestre() {}

    public Semestre(SemestreDto dto) {
        this.curso = Curso.findById(dto.curso().cdCurso());
        this.semestre = dto.semestre();
        this.disciplina = Disciplina.findById(dto.disciplina().cdDisciplina());
    }

    public static List<Semestre> extractEntitiesFromDto(SemestrePutDto dto) {
        return dto.disciplinas()
            .stream().map(disciplina ->
                new Semestre(
                    Curso.findById(disciplina.cdCurso()),
                    disciplina.semestre(),
                    Disciplina.findById(disciplina.cdDisciplina())
                )
            ).toList();
    }
}
