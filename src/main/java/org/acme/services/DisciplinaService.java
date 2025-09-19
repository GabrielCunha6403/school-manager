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
        return Disciplina.<Disciplina>find("cdCurso = ?1", cdCurso).stream().map(DisciplinaDto::new)
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
        Disciplina disciplina = Disciplina.findById(dto.getCdDisciplina());
        disciplina.nmDisciplina = dto.getNmDisciplina();
        disciplina.nrCreditos = dto.getNrCreditos();
        disciplina.semestre = dto.getSemestre();
        disciplina.professores = dto.getProfessores().stream()
                .map(userDto -> (User) User.findById(userDto.getCdUser()))
                .collect(Collectors.toList());

        disciplina.persist();

        return dto;
    }

    @Transactional
    public void deleteDisciplina(Long cdDisciplina) {
        Disciplina.deleteById(cdDisciplina);
    }

}
