package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.acme.dto.CursoDto;
import org.acme.dto.UserDto;
import org.acme.entities.Curso;
import org.acme.entities.User;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CursoService {

    public List<CursoDto> listCursos() {
        return Curso.<Curso>listAll()
                .stream().map(CursoDto::new)
                .collect(Collectors.toList());
    }

    public CursoDto getCurso(Long cdCurso) {
        return new CursoDto(Curso.findById(cdCurso));
    }

    public List<UserDto> listProfessoresFromCurso(Long cdCurso) {
        return User.<User>find(
                "SELECT DISTINCT p FROM Disciplina d " +
                        "JOIN d.professores p " +
                        "WHERE d.curso.cdCurso = ?1",
                cdCurso)
                .stream().map(UserDto::new)
                .collect(Collectors.toList());
    }

    public List<UserDto> listCoordenadores() {
        return User.<User>find("tpUser.cdTpUser = 2")
                .stream().map(UserDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public CursoDto postCurso(CursoDto dto) {
        new Curso(dto).persist();
        return dto;
    }

    @Transactional
    public CursoDto editCurso(CursoDto dto) {
        Curso curso = Curso.findById(dto.getCdCurso());
        curso.nmCurso = dto.getNmCurso();
        curso.coordenador = dto.getCoordenador();
        curso.nrCargaHoraria = dto.getNrCargaHoraria();

        curso.persist();

        return dto;
    }

    @Transactional
    public void deleteCurso(Long cdCurso) {
        Curso.deleteById(cdCurso);
    }

}
