package com.dal.pharma.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity(debug = true)
@EnableMethodSecurity
public class PharmaSecurityConfig {

	@Autowired
	PharmaAuthProvider pharmaAuthProvider;

	@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
				.requestMatchers("/v2/api-docs", "/v3/api-docs/**", "/swagger-resources/configuration/ui",
						"/swagger-resources/configuration/security", "/webjars/**", "/swagger-ui.html",
						"/swagger-ui/**")
				.permitAll().requestMatchers("/login/**").permitAll()
				.requestMatchers("/addMedicine/**").permitAll()
				.requestMatchers("/editMedicine/**").authenticated()
				.requestMatchers("/deleteMedInfo/{medId}/**").authenticated()
				.requestMatchers("/findMedicine/{medId}/**").authenticated()
				.requestMatchers("/viewMedicine/**").authenticated()

				.requestMatchers("/addCustomer/**").authenticated()
				.requestMatchers("/editCustomer/**").authenticated()
				.requestMatchers("/deleteCustomerInfo/{custId}/**").authenticated()
				.requestMatchers("/findCustomer/{custId}/**").authenticated()
				.requestMatchers("/viewCustomer/**").authenticated()

				.requestMatchers("/addSale/**").authenticated()
				.requestMatchers("/findSale/{saleId}/**").authenticated()
				.requestMatchers("/viewSales/**").authenticated()
				.requestMatchers("/addPharmauser/**").authenticated()
				.requestMatchers("/sortSalesByDate/**").authenticated();

		http.httpBasic();
		http.csrf().disable();
		http.cors();
		return http.build();
	}

	@Bean
	public AuthenticationManager authManager(HttpSecurity http) throws Exception {

		AuthenticationManagerBuilder authenticationManagerBuilder = http
				.getSharedObject(AuthenticationManagerBuilder.class);
		authenticationManagerBuilder.authenticationProvider(pharmaAuthProvider);
		return authenticationManagerBuilder.build();
	}

	@Bean
	public CorsFilter corsFilter() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*"); // this allows all origin
		config.addAllowedHeader("*"); // this allows all headers
		config.addAllowedMethod("OPTIONS");
		config.addAllowedMethod("HEAD");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("DELETE");
		config.addAllowedMethod("PATCH");
		config.setExposedHeaders(Arrays.asList("Authorization"));
		config.setMaxAge((long) 3600000);
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}

}