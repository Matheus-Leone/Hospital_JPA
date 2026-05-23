package com.example.hospital.dto;

import com.example.hospital.model.Paciente;

public class PacienteResponseDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String telefone;

    public PacienteResponseDTO(Paciente paciente) {
        this.id = paciente.getId();
        this.nome = paciente.getNome();
        this.cpf = paciente.getCpf();
        this.telefone = paciente.getTelefone();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }
}