package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.acme.dto.SemestreDto;
import org.acme.dto.SemestrePutDto;
import org.acme.entities.Curso;
import org.acme.entities.Semestre;

import java.util.List;

@ApplicationScoped
public class SemestreService {

    public List<SemestreDto> listarPorCurso(Long cdCurso) {
        return Semestre.<Semestre>find("curso.cdCurso = ?1", cdCurso)
                .list()
                .stream()
                .map(SemestreDto::new)
                .toList();
    }

    @Transactional
    public Long updateMatrizCurricular(List<SemestrePutDto> list, Long cdCurso) {
        Curso curso = Curso.findById(cdCurso);
        Semestre.delete("curso = ?1", curso);
        if (!list.isEmpty()) {
            for (SemestrePutDto dto : list) {
                List<Semestre> novosSemestres = Semestre.extractEntitiesFromDto(dto);
                for (Semestre semestre : novosSemestres) {
                    semestre.curso = curso;
                    semestre.persist();
                }
            }
        }
        return cdCurso;
    }
}
