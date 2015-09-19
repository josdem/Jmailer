package com.security.oauth2;

import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.NoSuchClientException;

public class GuestServiceImpl implements ClientDetailsService {
	
	private ClientDetailsCredentialsImpl credentials;
	
	public GuestServiceImpl() {
		credentials = new ClientDetailsCredentialsImpl();
	}
	
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		if (clientId.equals(credentials.getKey())) {
			return credentials.getBaseClientDetails();
		} else {
			throw new NoSuchClientException("No client recognized with key: " + clientId);
		}
	}
  
	public String getKey() {
		return credentials.getKey();
	}
	
	public void setKey(String key) {
		credentials.setKey(key);;
	}
	
	public String getSecret() {
		return credentials.getSecret();
	}
	
	public void setSecret(String secret) {
		credentials.setSecret(secret);
	}
		
}
