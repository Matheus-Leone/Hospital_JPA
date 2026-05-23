package com.example.hospital.exception;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class ApiErrorDTO {

    @Getter
    private List<String> erros;

    public ApiErrorDTO(String mensagem){
        this.erros = Arrays.asList(mensagem);
    }

    public ApiErrorDTO(List<String> erros){
        this.erros = erros;
    }
}