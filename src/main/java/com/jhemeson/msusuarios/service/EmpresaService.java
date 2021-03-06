package com.jhemeson.msusuarios.service;

import com.jhemeson.msusuarios.dto.Empresa.EmpresaDTO;
import com.jhemeson.msusuarios.dto.General.MessageResponseDTO;
import com.jhemeson.msusuarios.entity.Empresa;
import com.jhemeson.msusuarios.mapper.EmpresaMapper;
import com.jhemeson.msusuarios.repository.EmpresaRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {
    private EmpresaRepository empresaRepository;
    private final EmpresaMapper empresaMapper = EmpresaMapper.INSTANCE;

    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public MessageResponseDTO create(EmpresaDTO empresaDTO) {
        Empresa empresa = empresaMapper.toModel(empresaDTO);
        Empresa empresaCreated = empresaRepository.save(empresa);

        return MessageResponseDTO.builder().
                message(empresaCreated.getNome() + " criada com sucesso.")
                .id(empresaCreated.getId())
                .build();
    }

    public EmpresaDTO findById(Long id) throws NotFoundException {
        Empresa empresa = empresaRepository.findById(id).orElseThrow(() -> new NotFoundException("Empresa não encontrada."));
        return empresaMapper.toDTO(empresa);
    }

    public MessageResponseDTO update(EmpresaDTO empresaDTO) {
        Empresa empresa = empresaMapper.toModel(empresaDTO);
        Empresa empresaUpdated = empresaRepository.save(empresa);

        return MessageResponseDTO.builder().
                message(empresaUpdated.getNome() + " atualizada com sucesso.")
                .id(empresaUpdated.getId())
                .build();
    }

    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }
}
