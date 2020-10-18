package com.cloud.wzx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //定义用户服务(查询用户信息)

    @Bean
    public UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager detailsManager = new InMemoryUserDetailsManager();
        detailsManager.createUser(User.withUsername("wzx").password("123").authorities("text").build());
        detailsManager.createUser(User.withUsername("cwj").password("456").authorities("image").build());

        return detailsManager;
    }
    //密码编码器

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    //拦截机制

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/res/text").hasAuthority("text")
                .antMatchers("/res/image").hasAuthority("image")//对于/r下面的需要验证
                .antMatchers("/res/**").authenticated()
                //其他页面,请求允许访问
                .anyRequest().permitAll().and()
                //允许表单登陆
                .formLogin()
                .loginPage("/login.html")
        .successForwardUrl("/login-success");
        http.csrf().disable();
    }
}
