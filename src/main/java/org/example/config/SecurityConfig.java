package org.example.config;

import io.swagger.models.HttpMethod;
import lombok.RequiredArgsConstructor;
import org.example.config.security.TravelPasswordEncoder;
import org.example.model.UserRole;
import org.example.service.UserService;
import org.example.service.impl.TravelUserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();
//    }
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("users", "trainings", "photos", "find-all-by-gallery"
//                , "news", "find-all-by-country", "interviews", "galleries");
//    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/users/**").hasRole(UserRole.ADMIN.getName())
//                .antMatchers("/user/**").hasAnyRole(UserRole.MAIN_ADMIN.getName())
//                .antMatchers("/**").permitAll()
//                .and().formLogin();
//    }

    private final UserService userService;

    @Bean
    public TravelUserDetailsServiceImpl userDetailsService() {
        return new TravelUserDetailsServiceImpl(userService);
    }

    @Bean
    public TravelPasswordEncoder passwordEncoder() {
        return new TravelPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/trainings/findAll"
                        , "/photos/findAll", "/photos/find-all-by-gallery"
                        , "/news/findAll", "/news/find-all-by-country"
                        , "/interviews/findAll"
                        , "/galleries/findAll").anonymous()
                .antMatchers("/trainings"
                        , "/photos"
                        , "/news"
                        , "/interviews"
                        , "/galleries"
                        , "/banners").hasAnyAuthority(UserRole.ADMIN.getName(), UserRole.MAIN_ADMIN.getName())
                .antMatchers("/actions"
                , "/users").hasAnyAuthority(UserRole.MAIN_ADMIN.getName())
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/403");
    }
}
