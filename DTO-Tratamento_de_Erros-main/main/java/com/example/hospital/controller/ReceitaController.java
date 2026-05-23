package com.example.hospital.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.hospital.dto.ReceitaRequestDTO;
import com.example.hospital.dto.ReceitaResponseDTO;
import com.example.hospital.service.ReceitaService;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {

    private final ReceitaService service;

    public ReceitaController(ReceitaService service) {
        this.service = service;
    }

    @GetMapping
    public List<ReceitaResponseDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ReceitaResponseDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public ReceitaResponseDTO salvar(@RequestBody ReceitaRequestDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    public ReceitaResponseDTO atualizar(@PathVariable Long id, @RequestBody ReceitaRequestDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        return service.deletar(id)
                ? "Receita removida com sucesso!"
                : "Receita não encontrada!";
    }
}