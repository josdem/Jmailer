package com.tim.web.security.oauth2;

import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.jos.dem.state.ApplicationState;

public class UserValidatorImpl implements UserValidator {
	
	@Autowired
	private Properties oauth2;
	
	private Log log = LogFactory.getLog(getClass());
	
	@Override
	public boolean isValidUser(String user, String password) {
		log.info("LOGIN WITH CREDENTIALS: " + user + " password: " + password);
		
		String integraUsername = oauth2.getProperty(ApplicationState.USERNAME);
		String integraPassword = oauth2.getProperty(ApplicationState.PASSWORD);
		
		return (user.equals(integraUsername) && password.equals(integraPassword));
	}

}
