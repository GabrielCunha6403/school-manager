package org.acme.dto;

import org.acme.entities.Disciplina;
import org.acme.entities.User;

import java.util.List;
import java.util.stream.Collectors;

public class DisciplinaDto {
    private Long cdDisciplina;
    private String nmDisciplina;
    private Long semestre;
    private Long nrCreditos;
    private List<UserDto> professores;

    public DisciplinaDto() {}

    public DisciplinaDto(Disciplina disciplina) {
        this.cdDisciplina = disciplina.cdDisciplina;
        this.nmDisciplina = disciplina.nmDisciplina;
        this.semestre = disciplina.semestre;
        this.nrCreditos = disciplina.nrCreditos;
        this.professores = disciplina.professores.stream().map(UserDto::new).collect(Collectors.toList());
    }

    public List<UserDto> getProfessores() {
        return professores;
    }

    public void setProfessores(List<UserDto> professores) {
        this.professores = professores;
    }

    public Long getCdDisciplina() {
        return cdDisciplina;
    }

    public void setCdDisciplina(Long cdDisciplina) {
        this.cdDisciplina = cdDisciplina;
    }

    public String getNmDisciplina() {
        return nmDisciplina;
    }

    public void setNmDisciplina(String nmDisciplina) {
        this.nmDisciplina = nmDisciplina;
    }

    public Long getSemestre() {
        return semestre;
    }

    public void setSemestre(Long semestre) {
        this.semestre = semestre;
    }

    public Long getNrCreditos() {
        return nrCreditos;
    }

    public void setNrCreditos(Long nrCreditos) {
        this.nrCreditos = nrCreditos;
    }
}
