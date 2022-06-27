package com.academy.devdojo.springboot.config;

import com.academy.devdojo.springboot.service.DevDojoUserDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import javax.servlet.http.Cookie;

/**
 * BasicAuthenticationFilter
 * UsernamePasswordAuthenticationFilter
 * DefaultLoginPageGeneratingFilter
 * DefaultLogoutPageGeneratingFilter
 * FilterSecurityInterceptor
 * Authentication -> Authorization
 */

@EnableWebSecurity
@Log4j2
@EnableMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    private final DevDojoUserDetailsService devDojoUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
//                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .authorizeRequests()
                .antMatchers("/animes/admin/**").hasRole("ADMIN")
                .antMatchers("/animes/**").hasRole("USER")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        log.info("Password encoded {}",passwordEncoder.encode("java"));

        // Login in memory
        auth.inMemoryAuthentication()
                .withUser("anderson")
                .password(passwordEncoder.encode("java"))
                .roles("USER" , "ADMIN")
                .and()
                .withUser("devdojo")
                .password(passwordEncoder.encode("academy"))
                .roles("USER");

        //Login in database
        auth.userDetailsService(devDojoUserDetailsService)
                .passwordEncoder(passwordEncoder);
    }
}
