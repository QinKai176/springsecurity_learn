package com.betterarrow.springsecurity_learn.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 *
 */
//EnableWebSecurity注解有两个作用,
// 1: 加载了WebSecurityConfiguration配置类, 配置安全认证策略。
// 2: 加载了AuthenticationConfiguration, 配置了认证信息
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/myLogin.html")
                .loginProcessingUrl("/login")
                .permitAll().and().csrf().disable();
    }
}
