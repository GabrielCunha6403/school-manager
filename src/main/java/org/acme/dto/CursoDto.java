package org.acme.dto;

import org.acme.entities.Curso;
import org.acme.entities.User;

import java.util.List;

public record CursoDto(Long cdCurso, String nmCurso, User coordenador, Long nrCargaHoraria,
                       List<DisciplinaDto> disciplinas) {

    public CursoDto(Curso curso) {
        this(curso.cdCurso, curso.nmCurso, curso.coordenador, curso.nrCargaHoraria, curso.disciplinas.stream().map(DisciplinaDto::new).toList());
    }
}

