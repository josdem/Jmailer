package com.security.oauth2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.oauth2.provider.client.BaseClientDetails;

public class ClientDetailsCredentialsImpl implements ClientDetailsCredentials {
	
  private String clientKey;
  private String clientSecret;
  
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
		clientDetails.setClientId(clientKey);
		clientDetails.setClientSecret(clientSecret);
		clientDetails.setAuthorizedGrantTypes(authorizedGrantTypes);
		clientDetails.setScope(scopes);
		return clientDetails;
	}
	
	public String getClientKey() {
		return clientKey;
	}
	
	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}
	
	public String getClientSecret() {
		return clientSecret;
	}
	
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	
}
