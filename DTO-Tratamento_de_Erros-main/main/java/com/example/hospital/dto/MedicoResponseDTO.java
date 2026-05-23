package com.example.hospital.dto;

import com.example.hospital.model.Medico;

public class MedicoResponseDTO {

    private Long id;
    private String nome;
    private String especialidade;
    private String crm;

    public MedicoResponseDTO(Medico medico) {
        this.id = medico.getId();
        this.nome = medico.getNome();
        this.especialidade = medico.getEspecialidade();
        this.crm = medico.getCrm();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getCrm() {
        return crm;
    }
}