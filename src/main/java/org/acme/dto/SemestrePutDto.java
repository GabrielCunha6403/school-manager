package org.acme.dto;

import java.util.List;

public record SemestrePutDto(Long semestre, List<DisciplinaDto> disciplinas) {}
