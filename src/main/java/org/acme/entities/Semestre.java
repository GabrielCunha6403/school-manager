package org.acme.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.acme.dto.DisciplinaDto;
import org.acme.dto.SemestreDto;
import org.acme.dto.SemestrePutDto;

import java.util.List;

@Entity
@Table(name = "SEMESTRES")
public class Semestre {

    @EmbeddedId
    private SemestreId id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CD_CURSO", nullable = false)
    public Curso curso;
    @Column(name = "SEMESTRE")
    public Long semestre;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CD_DISCIPLINA", nullable = false)
    public Disciplina disciplina;

    public Semestre(Curso curso, Long semestre, Disciplina disciplina) {
        this.id = new SemestreId(curso, semestre, disciplina);
        this.curso = curso;
        this.semestre = semestre;
        this.disciplina = disciplina;
    }

    public Semestre() {}

    public Semestre(SemestreDto dto) {
        this.curso = Curso.findById(dto.getCurso().getCdCurso());
        this.semestre = dto.getSemestre();
        this.disciplina = Disciplina.findById(dto.getDisciplina().getCdDisciplina());
    }



    public static List<Semestre> extractEntitiesFromDto(SemestrePutDto dto) {
        return dto.getDisciplinas()
            .stream().map(disciplina -> {
                return new Semestre(
                    Curso.findById(disciplina.getCdCurso()),
                    disciplina.getSemestre(),
                    Disciplina.findById(disciplina.getCdDisciplina())
                );
            }).toList();
    }
}
