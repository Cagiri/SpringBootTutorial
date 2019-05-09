//package com.payconiq.assignment.stock.security;
//
//import java.util.function.Function;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.User.UserBuilder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	
//	// Authentication : User --> Roles
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("user").password("user").roles("USER").and()
//									 .withUser("admin").password("admin").roles("USER", "ADMIN");
//	}
//
//	// Authorization : Role -> Access
//	// survey -> USER
//	protected void configure(HttpSecurity http) throws Exception {
//		http.httpBasic().and().authorizeRequests().antMatchers("**/stocks/**").hasRole("USER")
//												  .antMatchers("**/users/**").hasRole("USER")
//												  .antMatchers("/**").hasRole("ADMIN")
//												  .and().csrf().disable().headers().frameOptions().disable();
//	}
//
//	
//    @Bean
//    public UserDetailsService userDetailsService() {
//    	
//    	UserBuilder usrBuilder = User.withDefaultPasswordEncoder();
//			
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        
//        manager.createUser(usrBuilder.username("user").password("user").roles("USER").build());
//        manager.createUser(usrBuilder.username("admin").password("admin").roles("USER", "ADMIN").build());
//        return manager;
//
//    }
//}