package com.api.mybatis_spring.usuario.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserListDTO {

    private String nome;

    @NotBlank(message = "Ativo não pode ser vazio")
    @Pattern(regexp = "^[SN]$", message = "Ativo deve ser 'S' ou 'N'")
    private String ativo;

    public UserListDTO asParams() {
        this.nome = nome == null ? "" : nome;
        return this;
    }
}
