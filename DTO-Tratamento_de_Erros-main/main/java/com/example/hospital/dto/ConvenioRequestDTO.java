package com.example.hospital.dto;

public class ConvenioRequestDTO {

    private String nome;
    private String cnpj;

    public ConvenioRequestDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}