package com.api.mybatis_spring.usuario.controller;

import com.api.mybatis_spring.usuario.dto.UserListDTO;
import com.api.mybatis_spring.usuario.model.User;
import com.api.mybatis_spring.usuario.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

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

    @GetMapping("/listarPorFuncao")
    public ResponseEntity<List<User>> listarPorFuncao() {
        try {
            List<User> userList = userService.listarPorFuncao();
            return ResponseEntity.ok().body(userList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.badRequest().build();
        }
    }

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
