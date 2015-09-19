package com.security.oauth2;

import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.NoSuchClientException;

class GuestServiceImpl implements ClientDetailsService {

	private ClientDetailsCredentialsImpl credentials;

	public GuestServiceImpl() {
		credentials = new ClientDetailsCredentialsImpl();
	}

	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		if (clientId.equals(credentials.getClientKey())) {
			return credentials.getBaseClientDetails();
		} else {
			throw new NoSuchClientException("No client recognized with key: " + clientId);
		}
	}

	public String getClientKey() {
		return credentials.getClientKey();
	}

	public void setClientKey(String clientKey) {
		credentials.setClientKey(clientKey);
	}

	public String getClientSecret() {
		return credentials.getClientSecret();
	}

	public void setClientSecret(String clientSecret) {
		credentials.setClientSecret(clientSecret);
	}

}
