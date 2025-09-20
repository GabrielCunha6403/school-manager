package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.acme.dto.SemestreDto;
import org.acme.dto.SemestrePutDto;
import org.acme.entities.Curso;
import org.acme.entities.Semestre;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class SemestreService {

    @Inject
    EntityManager em;

    public List<SemestreDto> listarPorCurso(Long cdCurso) {
        Curso curso = Curso.findById(cdCurso);
        List<Semestre> semestres = em.createQuery(
                        "SELECT s FROM Semestre s WHERE s.id.curso = :curso", Semestre.class)
                .setParameter("curso", curso)
                .getResultList();

        return semestres.stream()
                .map(SemestreDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long updateMatrizCurricular(List<SemestrePutDto> list, Long cdCurso) {
        Curso curso = Curso.findById(cdCurso);
        em.createQuery("DELETE FROM Semestre s WHERE s.curso = :curso")
                .setParameter("curso", curso)
                .executeUpdate();
        if(!list.isEmpty()) {
            for (SemestrePutDto dto : list) {
                List<Semestre> novosSemestres = Semestre.extractEntitiesFromDto(dto);
                novosSemestres.forEach(semestre -> {
                    Long cdDisciplina = semestre.disciplina.cdDisciplina;
                    em.createNativeQuery("INSERT INTO SEMESTRES (CD_CURSO, CD_DISCIPLINA, SEMESTRE) VALUES (?1, ?2, ?3)")
                            .setParameter(1, cdCurso)
                            .setParameter(2, cdDisciplina)
                            .setParameter(3, semestre.semestre)
                            .executeUpdate();
                });
            }
        }
        return cdCurso;
    }

}
