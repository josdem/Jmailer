package com.tim.web.security.oauth2;

public interface UserValidator {
	 boolean isValidUser(String user, String password);
}
