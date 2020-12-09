package com.jhemeson.msusuarios.service;

import com.jhemeson.msusuarios.dto.AlocacaoDTO;
import com.jhemeson.msusuarios.dto.MessageResponseDTO;
import com.jhemeson.msusuarios.entity.Alocacao;
import com.jhemeson.msusuarios.mapper.AlocacaoMapper;
import com.jhemeson.msusuarios.repository.AlocacaoRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlocacaoService {
    private AlocacaoRepository alocacaoRepository;
    private final AlocacaoMapper alocacaoMapper = AlocacaoMapper.INSTANCE;

    @Autowired
    public AlocacaoService(AlocacaoRepository alocacaoRepository) {
        this.alocacaoRepository = alocacaoRepository;
    }

    public MessageResponseDTO create(AlocacaoDTO alocacaoDTO) {
        Alocacao alocacao = alocacaoMapper.toModel(alocacaoDTO);
        Alocacao alocacaoCreated = alocacaoRepository.save(alocacao);

        return MessageResponseDTO.builder().
                message(alocacaoCreated.getPessoa().getNome() + " - "
                        + alocacaoCreated.getEmpresa().getNome() + " criada com sucesso.")
                .build();
    }

    public AlocacaoDTO findById(Long id) throws NotFoundException {
        Alocacao alocacao = alocacaoRepository.findById(id).orElseThrow(() -> new NotFoundException("Alocação não encontrada."));
        return alocacaoMapper.toDTO(alocacao);
    }

    public MessageResponseDTO update(AlocacaoDTO alocacaoDTO) {
        Alocacao alocacao = alocacaoMapper.toModel(alocacaoDTO);
        Alocacao alocacaoUpdated = alocacaoRepository.save(alocacao);

        return MessageResponseDTO.builder().
                message(alocacaoUpdated.getPessoa().getNome() + " - "
                        + alocacaoUpdated.getEmpresa().getNome() + " atualizada com sucesso.")
                .build();
    }

    // TODO: fazer service para buscar alocação por usuário
    // TODO: fazer service para buscar alocação por empresa
    // TODO: fazer service para buscar alocação por usuário/empresa
}