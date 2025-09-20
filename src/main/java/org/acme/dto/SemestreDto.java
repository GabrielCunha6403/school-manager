package org.acme.dto;


import org.acme.entities.Semestre;

public class SemestreDto {
    private CursoDto curso;
    private Long semestre;
    private DisciplinaDto disciplina;

    public SemestreDto() {}

    public SemestreDto(Semestre semestre) {
        this.curso = new CursoDto(semestre.curso);
        this.semestre = semestre.semestre;
        this.disciplina = new DisciplinaDto(semestre.disciplina);
    }

    public CursoDto getCurso() {
        return curso;
    }

    public void setCurso(CursoDto curso) {
        this.curso = curso;
    }

    public Long getSemestre() {
        return semestre;
    }

    public void setSemestre(Long semestre) {
        this.semestre = semestre;
    }

    public DisciplinaDto getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(DisciplinaDto disciplina) {
        this.disciplina = disciplina;
    }
}
