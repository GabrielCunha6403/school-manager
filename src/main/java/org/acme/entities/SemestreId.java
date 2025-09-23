package org.acme.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SemestreId implements Serializable {
    @Column(name = "CD_CURSO", nullable = false)
    private Long cdCurso;
    @Column(name = "SEMESTRE", nullable = false)
    private Long semestre;
    @Column(name = "CD_DISCIPLINA", nullable = false)
    private Long cdDisciplina;

    public SemestreId() {}

    public SemestreId(Long cdCurso, Long semestre, Long cdDisciplina) {
        this.cdCurso = cdCurso;
        this.semestre = semestre;
        this.cdDisciplina = cdDisciplina;
    }

    public Long getCdCurso() { return cdCurso; }
    public void setCdCurso(Long cdCurso) { this.cdCurso = cdCurso; }
    public Long getSemestre() { return semestre; }
    public void setSemestre(Long semestre) { this.semestre = semestre; }
    public Long getCdDisciplina() { return cdDisciplina; }
    public void setCdDisciplina(Long cdDisciplina) { this.cdDisciplina = cdDisciplina; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SemestreId that = (SemestreId) o;
        return Objects.equals(cdCurso, that.cdCurso) &&
               Objects.equals(semestre, that.semestre) &&
               Objects.equals(cdDisciplina, that.cdDisciplina);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cdCurso, semestre, cdDisciplina);
    }
}
