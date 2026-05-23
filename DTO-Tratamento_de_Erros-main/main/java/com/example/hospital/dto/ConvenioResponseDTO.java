package com.example.hospital.dto;

import com.example.hospital.model.Convenio;

public class ConvenioResponseDTO {

    private Long id;
    private String nome;
    private String cnpj;

    public ConvenioResponseDTO(Convenio convenio) {
        this.id = convenio.getId();
        this.nome = convenio.getNome();
        this.cnpj = convenio.getCnpj();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }
}