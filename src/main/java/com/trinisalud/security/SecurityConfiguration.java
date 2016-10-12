package com.trinisalud.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.trinisalud.business.Role;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(securityService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		String customer = Role.CUSTOMER.toString();
		String ipsWorker = Role.IPS_WORKER.toString();
		http.httpBasic().and()
			.authorizeRequests()
			.antMatchers(HttpMethod.POST, "/authentication/on").permitAll()
			.antMatchers(HttpMethod.GET, "/customer").hasRole(customer)
			.antMatchers(HttpMethod.POST, "/customer").hasRole(ipsWorker)
			.antMatchers(HttpMethod.POST, "/certificate").hasRole(ipsWorker)
			.antMatchers(HttpMethod.GET, "/certificate").hasRole(customer)
			.antMatchers(HttpMethod.GET, "/certificate/**").hasRole(customer)
			.and().csrf().disable();
	}

}
