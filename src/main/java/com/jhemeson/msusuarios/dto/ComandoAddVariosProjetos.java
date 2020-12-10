package com.jhemeson.msusuarios.dto;

import com.jhemeson.msusuarios.dto.Projeto.ProjetoDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ComandoAddVariosProjetos {
    private List<ProjetoDTO> projetos;
}
