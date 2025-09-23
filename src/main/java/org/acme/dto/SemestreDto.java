package org.acme.dto;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.acme.entities.Semestre;

public record SemestreDto(CursoDto curso, Long semestre, DisciplinaDto disciplina) {
    public SemestreDto(Semestre semestre) {
        this(
            semestre.curso != null ? new CursoDto(semestre.curso) : null,
            semestre.semestre,
            semestre.disciplina != null ? new DisciplinaDto(semestre.disciplina) : null
        );
    }

}
