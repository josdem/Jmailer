package com.jos.dem.security.oauth2;

import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.NoSuchClientException;

class GuestServiceImpl implements ClientDetailsService {
	
	private KpmgClientDetaulsCredentials kpmgCredentials;
	private IntegraClientDetaulsCredentials integraCredentials;
	
	public GuestServiceImpl() {
		kpmgCredentials = new KpmgClientDetaulsCredentials();
		integraCredentials = new IntegraClientDetaulsCredentials();
	}
	
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		if (clientId.equals(integraCredentials.getIntegraKey())) {
			return integraCredentials.getBaseClientDetails();
		} else if (clientId.equals(kpmgCredentials.getKpmgKey())) {
			return kpmgCredentials.getBaseClientDetails();
		}
		else {
			throw new NoSuchClientException("No client recognized with key: " + clientId);
		}
	}
  
	public String getIntegraKey() {
		return integraCredentials.getIntegraKey();
	}
	
	public void setIntegraKey(String integraKey) {
		integraCredentials.setIntegraKey(integraKey);;
	}
	
	public String getIntegraSecret() {
		return integraCredentials.getIntegraSecret();
	}
	
	public void setIntegraSecret(String integraSecret) {
		integraCredentials.setIntegraSecret(integraSecret);
	}
	
	public String getKpmgKey() {
		return kpmgCredentials.getKpmgKey();
	}
	
	public void setKpmgKey(String kpmgKey) {
		kpmgCredentials.setKpmgKey(kpmgKey);;
	}
	
	public String getKpmgSecret() {
		return kpmgCredentials.getKpmgSecret();
	}
	
	public void setKpmgSecret(String kpmgSecret) {
		kpmgCredentials.setKpmgSecret(kpmgSecret);
	}
	
}
