package com.api.mybatis_spring.usuario.controller;

import com.api.mybatis_spring.usuario.dto.UserListDTO;
import com.api.mybatis_spring.usuario.model.User;
import com.api.mybatis_spring.usuario.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
@Tag(name = "Usuario", description = "Endpoints relacionados a usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(
            summary = "Busca todos os usuarios",
            description = "Busca todos os usuarios cadastrados no banco de dados"
    )
    @GetMapping
    public ResponseEntity<?> listarTodos() {
        try {
            List<User> userList = userService.listarTodos();
            return ResponseEntity.ok().body(userList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(
            summary = "Busca usuario por Id",
            description = "Busca usuario com base no Id informado"
    )
    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Integer id) {
        try {
            User user = userService.listarPorId(id);
            return ResponseEntity.ok().body(user);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(
            summary = "Busca usuarios com uma funcao",
            description = "Utiliza a função usuario.listar_usuarios para buscar todos os usuarios no banco de dados"
    )
    @GetMapping("/listarPorFuncao")
    public ResponseEntity<List<?>> listarPorFuncao() {
        try {
            List<User> userList = userService.listarPorFuncao();
            return ResponseEntity.ok().body(userList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(
            summary = "Busca usuarios com parametros",
            description = "Busca usuarios com base nos parametros informados na função usuario.listar_usuarios_por_status_e_nome"
    )
    @GetMapping("/listarComParams")
    public ResponseEntity<?> listarComParams(@Valid @RequestBody UserListDTO obj) {
        try {
            List<User> userList = userService.listarComParams(obj.asParams());
            return ResponseEntity.ok().body(userList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.badRequest().build();
        }
    }
}
