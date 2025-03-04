package com.api.mybatis_spring.usuario.service;

import com.api.mybatis_spring.usuario.model.User;
import com.api.mybatis_spring.usuario.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> listarTodos() {
        return this.userMapper.listarTodos();
    }

}
