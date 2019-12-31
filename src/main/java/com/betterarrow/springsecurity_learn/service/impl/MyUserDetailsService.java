package com.betterarrow.springsecurity_learn.service.impl;

import com.betterarrow.springsecurity_learn.entity.User;
import com.betterarrow.springsecurity_learn.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //从数据库尝试读取该用户
        User user = userMapper.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        user.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRoles()));

        return user;
    }
}
