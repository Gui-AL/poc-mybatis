package com.api.mybatis_spring.usuario.service;

import com.api.mybatis_spring.usuario.model.User;
import com.api.mybatis_spring.usuario.repository.UserMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {
    @Autowired
    private final UserMapper userMapper;

    public List<User> listarTodos() {
        System.out.println("Entrou");
        return userMapper.listarTodos();
    }

}
