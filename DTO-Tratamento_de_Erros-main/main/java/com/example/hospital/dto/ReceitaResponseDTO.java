package com.example.hospital.dto;

import com.example.hospital.model.Receita;

public class ReceitaResponseDTO {

    private Long id;
    private String medicamento;
    private String dosagem;
    private Integer duracaoDias;
    private Long consultaId;

    public ReceitaResponseDTO(Receita receita) {
        this.id = receita.getId();
        this.medicamento = receita.getMedicamento();
        this.dosagem = receita.getDosagem();
        this.duracaoDias = receita.getDuracaoDias();

        if (receita.getConsulta() != null) {
            this.consultaId = receita.getConsulta().getId();
        }
    }

    public Long getId() {
        return id;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public String getDosagem() {
        return dosagem;
    }

    public Integer getDuracaoDias() {
        return duracaoDias;
    }

    public Long getConsultaId() {
        return consultaId;
    }
}