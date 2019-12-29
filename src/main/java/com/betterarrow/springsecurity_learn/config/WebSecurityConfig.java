package com.betterarrow.springsecurity_learn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


/**
 *
 */
//EnableWebSecurity注解有两个作用,
// 1: 加载了WebSecurityConfiguration配置类, 配置安全认证策略。
// 2: 加载了AuthenticationConfiguration, 配置了认证信息
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();


        manager.createUser(User.withUsername("user1").password("123").roles("USER").build());
        manager.createUser(User.withUsername("admin").password("123").roles("USER", "ADMIN").build());
        return manager;
    }

    /**
     * 关于ant模式解析：
     * 1.*用来匹配0或者任意数量的字符
     * 2.**用来匹配0或者更多的目录
     * 3.？匹配任意单个字符
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().
                antMatchers("/admin/api/***").hasRole("ADMIN")
                .antMatchers("/user/api/**").hasRole("USER")
                .antMatchers("/app/api/**").permitAll()
                .anyRequest().authenticated().and().formLogin()
//                .loginPage("/myLogin.html")
//                .loginProcessingUrl("/login")
                .permitAll().and().csrf().disable();
    }
}
