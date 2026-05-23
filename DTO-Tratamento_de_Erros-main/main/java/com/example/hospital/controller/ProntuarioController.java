package com.example.hospital.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.hospital.dto.ProntuarioRequestDTO;
import com.example.hospital.dto.ProntuarioResponseDTO;
import com.example.hospital.service.ProntuarioService;

@RestController
@RequestMapping("/prontuarios")
public class ProntuarioController {

    private final ProntuarioService service;

    public ProntuarioController(ProntuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProntuarioResponseDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ProntuarioResponseDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public ProntuarioResponseDTO salvar(@RequestBody ProntuarioRequestDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    public ProntuarioResponseDTO atualizar(@PathVariable Long id, @RequestBody ProntuarioRequestDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        return service.deletar(id)
                ? "Prontuário removido com sucesso!"
                : "Prontuário não encontrado!";
    }
}