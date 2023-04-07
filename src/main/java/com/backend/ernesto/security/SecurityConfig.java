package com.backend.ernesto.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;

import com.backend.ernesto.security.jsonWebToken.JwtAuthenticationEntryPoint;
import com.backend.ernesto.security.jsonWebToken.JwtAuthenticationFilter;
import com.backend.ernesto.security.service.UserDetailsServiceImpl;

@EnableWebSecurity
@Configuration

public class SecurityConfig {

	@Autowired
	private JwtAuthenticationEntryPoint unauthorizedHandler;

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;

//    @Bean
//    PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
//    @Bean
//    AuthenticationManager authenticationManager(HttpSecurity http)
//            throws Exception {
//	    return http.getSharedObject(AuthenticationManagerBuilder.class)
//	      .userDetailsService(userDetailsServiceImpl)
//	      .passwordEncoder(passwordEncoder())
//	      .and()
//	      .build();
//	}

    @Bean
    AuthenticationProvider AuthenticationProvider() {
    	DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    	
    	authenticationProvider.setUserDetailsService(userDetailsServiceImpl);
    	authenticationProvider.setPasswordEncoder(passwordEncoder());
    	
    	return authenticationProvider;
    }

    @Bean
    AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

//    @Bean
//    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .cors().and().csrf().disable()
//                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
//                
//                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                
//        		.and().authorizeRequests().requestMatchers("/generate-token").permitAll()
//        		.requestMatchers("/usuario").permitAll().anyRequest().authenticated();
//        
//        http.authenticationProvider(daoAuthenticationProvider());
//
//        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//        return http.build();
//    }

//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.cors().and().csrf().disable().exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
//
//				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//
//				.and().authorizeHttpRequests((authorize) -> authorize.requestMatchers("/generate-token", "/usuario/")
//						.permitAll().requestMatchers(HttpMethod.OPTIONS).permitAll().anyRequest().authenticated());
//		
//		http.authenticationProvider(daoAuthenticationProvider());
//
//		http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//		return http.build();
//	}

//	@Bean
//	SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity.cors().and().csrf(csrf -> csrf.disable())
//			.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
//			.authorizeHttpRequests(auth -> auth.requestMatchers(new AntPathRequestMatcher("/generate-token", "usuario")).permitAll()
//						.requestMatchers(HttpMethod.OPTIONS).permitAll().anyRequest().authenticated())
//				.sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//
//		httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//		return httpSecurity.build();
//	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
				.cors().and().csrf().disable()
				.exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
				
				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				
				.and().authorizeHttpRequests(auth -> auth
						.requestMatchers("/generate-token","/usuario/").permitAll()
						.requestMatchers(HttpMethod.OPTIONS).permitAll()
						.anyRequest().authenticated());
		

		httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		return httpSecurity.build();
	}


}
