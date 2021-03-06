package com.jhemeson.msusuarios.controller;

import com.jhemeson.msusuarios.dto.Empresa.EmpresaDTO;
import com.jhemeson.msusuarios.dto.General.MessageResponseDTO;
import com.jhemeson.msusuarios.entity.Empresa;
import com.jhemeson.msusuarios.service.EmpresaService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/empresa")
public class EmpresaController {

    private EmpresaService empresaService;

    @Autowired
    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping("{id}")
    public EmpresaDTO buscarEmpresaPorId(@PathVariable Long id) throws NotFoundException {
        return empresaService.findById(id);
    }

    @GetMapping
    public List<Empresa> listarEmpresas() {
        return empresaService.findAll();
    }

    @PostMapping
    public MessageResponseDTO adicionarEmpresa(@RequestBody EmpresaDTO empresaDTO) {
        return empresaService.create(empresaDTO);
    }

    @PutMapping
    public MessageResponseDTO atualizarEmpresa(@RequestBody EmpresaDTO empresaDTO) {
        return empresaService.update(empresaDTO);
    }
}

