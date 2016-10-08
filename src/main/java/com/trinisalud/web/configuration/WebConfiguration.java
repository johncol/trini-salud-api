package com.trinisalud.web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfiguration {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				String webOrigin = System.getProperty("WEB_ORIGIN", "http://trini-salud-web.herokuapp.com/");
				String webOriginDev = "http://localhost:5000/";
				registry.addMapping(webOriginDev);
				registry.addMapping(webOrigin);
			}
		};
	}
	
}
