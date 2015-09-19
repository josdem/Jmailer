package com.jos.dem.security.oauth2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.oauth2.provider.client.BaseClientDetails;

public class IntegraClientDetaulsCredentials implements ClientDetailsCredentials {
	
	private String integraKey;
  private String integraSecret;
  
  List<String> authorizedGrantTypes = new ArrayList<String>();
  List<String> scopes = new ArrayList<String>();

  public IntegraClientDetaulsCredentials() {
  	authorizedGrantTypes.add("password");
  	authorizedGrantTypes.add("refresh_token");
  	authorizedGrantTypes.add("client_credentials");
  	
  	scopes.add("read,write");
	}
  
	@Override
	public BaseClientDetails getBaseClientDetails() {
		BaseClientDetails clientDetails = new BaseClientDetails();
		clientDetails.setClientId(integraKey);
		clientDetails.setClientSecret(integraSecret);
		clientDetails.setAuthorizedGrantTypes(authorizedGrantTypes);
		clientDetails.setScope(scopes);
		return clientDetails;
	}
	
	public String getIntegraKey() {
		return integraKey;
	}
	
	public void setIntegraKey(String integraKey) {
		this.integraKey = integraKey;
	}
	
	public String getIntegraSecret() {
		return integraSecret;
	}
	
	public void setIntegraSecret(String integraSecret) {
		this.integraSecret = integraSecret;
	}
	
}
