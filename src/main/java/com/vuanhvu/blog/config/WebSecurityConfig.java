//package com.vuanhvu.blog.config;
//
////import com.vuanhvu.blog.service.UserDetailsServiceImpl;
//
//import com.vuanhvu.blog.auth.CustomOAuth2UserService;
//import com.vuanhvu.blog.auth.MyCustomFbLoginSuccessHandler;
//import com.vuanhvu.blog.auth.MyCustomLoginSuccessHandler;
//import com.vuanhvu.blog.service.UserServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//
//import javax.annotation.Resource;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Resource
//    private UserDetailsService userDetailsService;
//
//    @Autowired
//    private CustomOAuth2UserService oauth2UserService;
//
//    @Autowired
//    private UserServiceImpl userService;
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService);
//        authProvider.setPasswordEncoder(passwordEncoder());
//
//        return authProvider;
//    }
//
//    @Bean
//    public AuthenticationSuccessHandler successHandler() {
//        return new MyCustomLoginSuccessHandler("/");
//    }
//
//    @Bean
//    public AuthenticationSuccessHandler successHandlerFb() {
//        return new MyCustomFbLoginSuccessHandler("/");
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/**").permitAll()
//                .and()
//                .formLogin()
//                .loginPage("/login").successHandler(successHandler())
//                .permitAll()
//                .and()
//                .oauth2Login()
//                .loginPage("/login")
//                .userInfoEndpoint()
//                .userService(oauth2UserService)
//                .and()
//                .successHandler(successHandlerFb())
//                .permitAll()
//                .and()
//                .logout().logoutUrl("/logout").logoutSuccessUrl("/").permitAll();
//    }
//
//
//}
