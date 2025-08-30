package edu.cca.john.semester.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import edu.cca.john.semester.services.UserDetailsServiceImpl;

@Configuration
public class SecurityConfig {
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	@Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
        		.csrf(csrf -> csrf.disable())
        		.authorizeHttpRequests(request-> request
                		//.anyRequest().permitAll())
        				.anyRequest().authenticated())
        		.sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .httpBasic(Customizer.withDefaults())
        		.build();
	}
	
	@Bean
    AuthenticationProvider authenticationProvider(){
		System.out.println("Authentication Provider...");
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsServiceImpl);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }
	@Bean
	PasswordEncoder passwordEncoder(){
		System.out.println("Password Encoder...");
		return new BCryptPasswordEncoder();
	}
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception{
		System.out.println("Authentication Manager...");
		return authConfig.getAuthenticationManager();
	}
}
