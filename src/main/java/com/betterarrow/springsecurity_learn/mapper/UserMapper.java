package com.betterarrow.springsecurity_learn.mapper;

import com.betterarrow.springsecurity_learn.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {

    @Select("select * from users WHERE username=#{username}")
    User findByUserName(@Param("username") String username);
}
