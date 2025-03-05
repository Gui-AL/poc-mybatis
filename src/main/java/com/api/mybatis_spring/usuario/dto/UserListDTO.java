package com.api.mybatis_spring.usuario.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserListDTO {

    @Size(min = 2, max = 50, message = "Nome entre 2 a 50 caracteres")
    private String nome;

    @NotBlank(message = "Ativo não pode ser vazio")
    @Size(min = 1, max = 1, message = "Ativo deve ser 'S' ou 'N'")
    @Pattern(regexp = "^[SN]$", message = "Ativo deve ser 'S' ou 'N'")
    private String ativo;

    public UserListDTO asParams() {
        this.nome = nome == null ? "" : nome;
        return this;
    }
}
