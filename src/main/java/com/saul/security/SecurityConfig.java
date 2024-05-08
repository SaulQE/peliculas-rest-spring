package com.saul.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("royer").password("{noop}r123").roles("USER");
        auth.inMemoryAuthentication().withUser("franklin").password("{noop}f123").roles("USER");
        auth.inMemoryAuthentication().withUser("mafer").password("{noop}m123").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("saul").password("{noop}s123").roles("ADMIN", "DBA");
    }

    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()

                .antMatchers("/pelicula/listar","/pelicula/buscar/*")
                .access("hasRole('USER') or hasRole('ADMIN') or (hasRole('ADMIN') and hasRole('DBA'))")

                .antMatchers("/pelicula/registrar","/pelicula/editar/*")
                .access("hasRole('ADMIN') or (hasRole('ADMIN') and hasRole('DBA'))")

                .antMatchers("/pelicula/borrar/*")
                .access("hasRole('ADMIN') and hasRole('DBA')");

        //Autenticación basica
        http.authorizeRequests().and()
                .httpBasic();
        //sesiones únicas
        http.authorizeRequests().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        //por ser app rest se desabilita
        http.authorizeRequests().and()
                .csrf().disable();
    }

}
