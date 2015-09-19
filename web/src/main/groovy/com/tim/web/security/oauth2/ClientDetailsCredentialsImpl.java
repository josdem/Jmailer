package com.tim.web.security.oauth2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.oauth2.provider.client.BaseClientDetails;

public class ClientDetailsCredentialsImpl implements ClientDetailsCredentials {
	
	private String key;
  private String secret;
  
  List<String> authorizedGrantTypes = new ArrayList<String>();
  List<String> scopes = new ArrayList<String>();

  public ClientDetailsCredentialsImpl() {
  	authorizedGrantTypes.add("password");
  	authorizedGrantTypes.add("refresh_token");
  	authorizedGrantTypes.add("client_credentials");
  	
  	scopes.add("read,write");
	}
  
	@Override
	public BaseClientDetails getBaseClientDetails() {
		BaseClientDetails clientDetails = new BaseClientDetails();
		clientDetails.setClientId(key);
		clientDetails.setClientSecret(secret);
		clientDetails.setAuthorizedGrantTypes(authorizedGrantTypes);
		clientDetails.setScope(scopes);
		return clientDetails;
	}

	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public String getSecret() {
		return secret;
	}
	
	public void setSecret(String secret) {
		this.secret = secret;
	}
	
}
