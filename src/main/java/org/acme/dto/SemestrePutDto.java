package org.acme.dto;

import java.util.List;

public class SemestrePutDto {
    private Long semestre;
    private List<DisciplinaDto> disciplinas;

    public SemestrePutDto() {}

    public Long getSemestre() {
        return semestre;
    }

    public void setSemestre(Long semestre) {
        this.semestre = semestre;
    }

    public List<DisciplinaDto> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<DisciplinaDto> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
