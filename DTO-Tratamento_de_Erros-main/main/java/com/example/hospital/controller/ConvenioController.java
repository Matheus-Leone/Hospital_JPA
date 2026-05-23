package com.example.hospital.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.hospital.dto.ConvenioRequestDTO;
import com.example.hospital.dto.ConvenioResponseDTO;
import com.example.hospital.service.ConvenioService;

@RestController
@RequestMapping("/convenios")
public class ConvenioController {

    private final ConvenioService service;

    public ConvenioController(ConvenioService service) {
        this.service = service;
    }

    @GetMapping
    public List<ConvenioResponseDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ConvenioResponseDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public ConvenioResponseDTO salvar(@RequestBody ConvenioRequestDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    public ConvenioResponseDTO atualizar(@PathVariable Long id, @RequestBody ConvenioRequestDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        return service.deletar(id)
                ? "Convênio removido com sucesso!"
                : "Convênio não encontrado!";
    }
}