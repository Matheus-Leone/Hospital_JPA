package com.example.hospital.dto;

import com.example.hospital.model.Prontuario;

public class ProntuarioResponseDTO {

    private Long id;
    private String tipoSanguineo;
    private String alergia;
    private String observacoes;
    private Long pacienteId;

    public ProntuarioResponseDTO(Prontuario prontuario) {
        this.id = prontuario.getId();
        this.tipoSanguineo = prontuario.getTipoSanguineo();
        this.alergia = prontuario.getAlergia();
        this.observacoes = prontuario.getObservacoes();

        if (prontuario.getPaciente() != null) {
            this.pacienteId = prontuario.getPaciente().getId();
        }
    }

    public Long getId() {
        return id;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public String getAlergia() {
        return alergia;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public Long getPacienteId() {
        return pacienteId;
    }
}