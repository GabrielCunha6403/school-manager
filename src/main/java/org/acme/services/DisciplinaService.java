package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.acme.dto.DisciplinaDto;
import org.acme.entities.Disciplina;
import org.acme.entities.User;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class DisciplinaService {

    public DisciplinaDto getDisciplina(Long cdDisciplina) {
        return new DisciplinaDto(Disciplina.findById(cdDisciplina));
    }

    public List<DisciplinaDto> listDisciplina(Long cdCurso) {
        return Disciplina.<Disciplina>find("curso.cdCurso = ?1", cdCurso)
                .list()
                .stream().map(DisciplinaDto::new)
                .collect(Collectors.toList());
    }

    public List<DisciplinaDto> listarDisciplinasBySemestre(Long cdCurso, Long semestre) {
        return Disciplina.<Disciplina>find("curso.cdCurso = ?1 AND semestre = ?2", cdCurso, semestre)
                .list()
                .stream().map(DisciplinaDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public DisciplinaDto postDisciplina(DisciplinaDto dto) {
        Disciplina disciplina = new Disciplina(dto);
        disciplina.persist();
        return dto;
    }
    
    @Transactional
    public DisciplinaDto editDisciplina(DisciplinaDto dto) {
        Disciplina disciplina = Disciplina.findById(dto.cdDisciplina());
        disciplina.nmDisciplina = dto.nmDisciplina();
        disciplina.nrCreditos = dto.nrCreditos();
        disciplina.semestre = dto.semestre();
        disciplina.professores = dto.professores() != null ? dto.professores().stream()
                .map(userDto -> (User) User.findById(userDto.cdUser()))
                .toList() : null;

        disciplina.persist();

        return dto;
    }

    @Transactional
    public void deleteDisciplina(Long cdDisciplina) {
        Disciplina.deleteById(cdDisciplina);
    }

}
