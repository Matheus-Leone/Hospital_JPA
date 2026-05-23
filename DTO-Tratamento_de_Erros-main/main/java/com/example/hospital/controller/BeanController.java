package com.example.hospital.controller;

import com.example.hospital.model.Paciente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeanController {

    private final Paciente paciente;

    public BeanController(Paciente paciente) {
        this.paciente = paciente;
    }

    @GetMapping("/bean/paciente")
    public Paciente buscarPacienteBean() {
        return paciente;
    }
}