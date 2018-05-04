package com.biswa.springangular.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableResourceServer
@EnableWebSecurity
public class ResourceServer extends ResourceServerConfigurerAdapter {
	
	
	
@Override
public void configure(HttpSecurity http) throws Exception {
	// TODO Auto-generated method stub
	http.authorizeRequests()
	.antMatchers("/").permitAll()
	.antMatchers("/api/**").authenticated()
	.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	.and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler())
	.and().csrf().disable();
}

/*@Autowired      // here is configuration related to spring boot basic authentication
public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()                                               // static users
        .withUser("skaterik").password("pass").roles("USER")
        .and()
        .withUser("zone2").password("mypassword").roles("USER")
        .and()
        .withUser("zone3").password("mypassword").roles("USER")
        .and()
        .withUser("zone4").password("mypassword").roles("USER")
        .and()
        .withUser("zone5").password("mypassword").roles("USER");
}*/

@Bean
public FilterRegistrationBean corsFilter() {
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    CorsConfiguration config = new CorsConfiguration();
    config.setAllowCredentials(true);
    config.addAllowedOrigin("*");
    config.addAllowedHeader("*");
    config.addAllowedMethod("*");
    source.registerCorsConfiguration("/**", config);
    FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
    bean.setOrder(0);
    return bean;
}
}
