package com.api.mybatis_spring.usuario.repository;

import com.api.mybatis_spring.usuario.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    List<User> listarTodos();
}
