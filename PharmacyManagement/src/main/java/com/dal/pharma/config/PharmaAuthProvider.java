package com.dal.pharma.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.dal.pharma.entity.PharmaLogin;
import com.dal.pharma.repo.PharmaRepo;

@Component
public class PharmaAuthProvider implements AuthenticationProvider {

	@Autowired
	PharmaRepo pharmarepos;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = authentication.getName();
		String pwd = authentication.getCredentials().toString();
		PharmaLogin pharmaLogin = pharmarepos.findBypharmauser(username);

		if (pharmaLogin == null) {
			throw new StackOverflowError("No user got registered");
		} else if (pwd.equals(pharmaLogin.getPharmapass())) {
			List<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(pharmaLogin.getPharmauser()));
			return new UsernamePasswordAuthenticationToken(username, pwd, authorities);
		} else {
			System.out.println("I am a bad credentails");
			throw new StackOverflowError("Invalid Password");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}