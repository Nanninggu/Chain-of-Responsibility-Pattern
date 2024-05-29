package com.example.Chain.of.Responsibility.Pattern.mapper;

import com.example.Chain.of.Responsibility.Pattern.dto.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO users(username, email, password) VALUES(#{username}, #{email}, #{password})")
    void insertUser(User user);

    Object getUsers();
}
