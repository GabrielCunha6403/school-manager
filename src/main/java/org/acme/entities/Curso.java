package org.acme.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.acme.dto.CursoDto;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CURSOS")
public class Curso extends PanacheEntityBase {
    @Id
    @GeneratedValue
    @Column(name = "CD_CURSO")
    public Long cdCurso;
    @Column(name = "NM_CURSO")
    public String nmCurso;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CD_COORDENADOR", referencedColumnName = "CD_USER")
    public User coordenador;
    @Column(name = "NR_CARGA_HORARIA")
    public Long nrCargaHoraria;
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Disciplina> disciplinas = new ArrayList<>();

    public Curso() {}

    public Curso(CursoDto dto) {
        this.cdCurso = dto.getCdCurso();
        this.nmCurso = dto.getNmCurso();
        this.coordenador = dto.getCoordenador();
        this.nrCargaHoraria = dto.getNrCargaHoraria();
    }

}
