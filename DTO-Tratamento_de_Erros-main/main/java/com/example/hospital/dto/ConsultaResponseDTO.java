package com.example.hospital.dto;

import com.example.hospital.model.Consulta;

public class ConsultaResponseDTO {

    private Long id;
    private String dataHora;
    private String motivo;
    private Double valor;

    private Long pacienteId;
    private Long medicoId;
    private Long convenioId;

    public ConsultaResponseDTO(Consulta consulta) {
        this.id = consulta.getId();
        this.dataHora = consulta.getDataHora().toString();
        this.motivo = consulta.getMotivo();
        this.valor = consulta.getValor();

        if (consulta.getPaciente() != null) {
            this.pacienteId = consulta.getPaciente().getId();
        }

        if (consulta.getMedico() != null) {
            this.medicoId = consulta.getMedico().getId();
        }

        if (consulta.getConvenio() != null) {
            this.convenioId = consulta.getConvenio().getId();
        }
    }

    public Long getId() {
        return id;
    }

    public String getDataHora() {
        return dataHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public Double getValor() {
        return valor;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public Long getMedicoId() {
        return medicoId;
    }

    public Long getConvenioId() {
        return convenioId;
    }
}