package com.api.mybatis_spring.usuario.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {

    @JsonProperty("usr_usuario")
    private Integer id;

    @JsonProperty("usr_nome")
    private String nome;

    @JsonProperty("usr_ativo")
    private String ativo;

    @JsonProperty("usr_dt_created_at")
    @JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataCriacao;
}
