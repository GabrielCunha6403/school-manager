package org.acme.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SemestreId implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CD_CURSO", nullable = false, insertable = false, updatable = false)
    private Curso curso;
    @Column(insertable=false, updatable=false)
    private Long semestre;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CD_DISCIPLINA", nullable = false, insertable = false, updatable = false)
    private Disciplina disciplina;

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Long getSemestre() {
        return semestre;
    }

    public void setSemestre(Long semestre) {
        this.semestre = semestre;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public SemestreId() {}

    public SemestreId(Curso curso, Long semestre, Disciplina disciplina) {
        this.curso = curso;
        this.semestre = semestre;
        this.disciplina = disciplina;
    }

}

