package org.acme.dto;

import org.acme.entities.Curso;
import org.acme.entities.User;

import java.util.List;

public class CursoDto {
    private Long cdCurso;
    private String nmCurso;
    private User coordenador;
    private Long nrCargaHoraria;
    private List<DisciplinaDto> disciplinas;

    public CursoDto() {}
    
    public CursoDto(Curso curso) {
        this.cdCurso = curso.cdCurso;
        this.nmCurso = curso.nmCurso;
        this.coordenador = curso.coordenador;
        this.nrCargaHoraria = curso.nrCargaHoraria;
        this.disciplinas = curso.disciplinas.stream().map(DisciplinaDto::new).toList();
    }

    public Long getCdCurso() {
        return cdCurso;
    }

    public void setCdCurso(Long cdCurso) {
        this.cdCurso = cdCurso;
    }

    public String getNmCurso() {
        return nmCurso;
    }

    public void setNmCurso(String nmCurso) {
        this.nmCurso = nmCurso;
    }

    public User getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(User coordenador) {
        this.coordenador = coordenador;
    }

    public Long getNrCargaHoraria() {
        return nrCargaHoraria;
    }

    public void setNrCargaHoraria(Long nrCargaHoraria) {
        this.nrCargaHoraria = nrCargaHoraria;
    }

    public List<DisciplinaDto> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<DisciplinaDto> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
