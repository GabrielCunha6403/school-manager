package org.acme.dto;

import org.acme.entities.Disciplina;

import java.util.List;

public record DisciplinaDto(Long cdDisciplina, String nmDisciplina, Long semestre, Long nrCreditos, List<UserDto> professores, Long cdCurso) {
    public DisciplinaDto(Disciplina disciplina) {
        this(
            disciplina.cdDisciplina,
            disciplina.nmDisciplina,
            disciplina.semestre,
            disciplina.nrCreditos,
            disciplina.professores != null ? disciplina.professores.stream().map(UserDto::new).toList() : null,
            disciplina.curso != null ? disciplina.curso.cdCurso : null
        );
    }
}
