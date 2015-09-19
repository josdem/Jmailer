package com.jos.dem.security.oauth2;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

class UserAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private Properties oauth2;
	@Autowired
	private UserValidator userValidator;
	
	private Log log = LogFactory.getLog(getClass());

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		log.info("authentication: " + ToStringBuilder.reflectionToString(authentication));
		boolean result = isValidUser(authentication.getPrincipal().toString(), authentication.getCredentials().toString());
		log.info("RESULT IN AUTH: " + result);
		if (result) {
			List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
			UserAuthenticationToken auth = new UserAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(), grantedAuthorities);
			return auth;
		} else {
			throw new BadCredentialsException("Bad User Credentials.");
		}
	}

	public boolean supports(Class<?> authentication) {
		return true;
	}

	public boolean isValidUser(String user, String password) {
		return userValidator.isValidUser(user, password);
	}
	
}
