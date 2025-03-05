package com.api.mybatis_spring.usuario.repository;

import com.api.mybatis_spring.usuario.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> listarTodos();

    User listarPorId(Integer id);

    List<User> listarPorFuncao();

    List<User> listarComParams(String ativo, String nome);
}
