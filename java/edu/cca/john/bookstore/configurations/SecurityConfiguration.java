package edu.cca.john.bookstore.configurations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import edu.cca.john.bookstore.models.MyUserDetailsService;
import edu.cca.john.bookstore.jwt.JWTRequestFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	@Autowired
	private JWTRequestFilter jwtRequestFilter;
	@Autowired
	private CorsFilterConfig corsFilterConfig;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.csrf(customizer -> customizer.disable());
		//http.authorizeHttpRequests(req -> req.anyRequest().permitAll());
		http.authorizeHttpRequests(req -> req
				.requestMatchers("/book/auth/api/**").permitAll()
				.requestMatchers("/book/user/api/**","/book/role/api/**").hasRole("ADMIN")
				.requestMatchers("/book/db/api/readbooks","/book/db/api/getbookbybno").hasAnyRole("USER","MANAGER")
        		.requestMatchers("/book/db/api/createbook","/book/db/api/updatebook","/book/db/api/deletebook").hasRole("MANAGER")
				.anyRequest().authenticated());
		//http.formLogin(Customizer.withDefaults());
		http.httpBasic(Customizer.withDefaults());
		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		http.authenticationProvider(authenticationProvider()).addFilterBefore(corsFilterConfig,UsernamePasswordAuthenticationFilter.class);
		http.authenticationProvider(authenticationProvider()).addFilterBefore(jwtRequestFilter,UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user1=User.withDefaultPasswordEncoder().username("abc").password("abc").roles("USER").build();
		UserDetails user2=User.withDefaultPasswordEncoder().username("def").password("def").roles("USER").build();
		UserDetails user3=User.withDefaultPasswordEncoder().username("ghi").password("ghi").roles("USER").build();
		//return new InMemoryUserDetailsManager(user1,user2,user3);
		
		List<UserDetails> users = new ArrayList<UserDetails>();
		users.add(user1);
		users.add(user2);
		users.add(user3);
		return new InMemoryUserDetailsManager(users);
		
	}
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder());
		provider.setUserDetailsService(myUserDetailsService);
		return provider;
	}
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception{
		return authConfig.getAuthenticationManager();
	}
}