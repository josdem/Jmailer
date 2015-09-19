package com.jos.dem.security.oauth2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.oauth2.provider.client.BaseClientDetails;

public class KpmgClientDetaulsCredentials implements ClientDetailsCredentials {
	
	private String kpmgKey;
  private String kpmgSecret;
  
  List<String> authorizedGrantTypes = new ArrayList<String>();
  List<String> scopes = new ArrayList<String>();

  public KpmgClientDetaulsCredentials() {
  	authorizedGrantTypes.add("password");
  	authorizedGrantTypes.add("refresh_token");
  	authorizedGrantTypes.add("client_credentials");
  	
  	scopes.add("read,write");
	}
  
	@Override
	public BaseClientDetails getBaseClientDetails() {
		BaseClientDetails clientDetails = new BaseClientDetails();
		clientDetails.setClientId(kpmgKey);
		clientDetails.setClientSecret(kpmgSecret);
		clientDetails.setAuthorizedGrantTypes(authorizedGrantTypes);
		clientDetails.setScope(scopes);
		return clientDetails;
	}

	public String getKpmgKey() {
		return kpmgKey;
	}
	
	public void setKpmgKey(String kpmgKey) {
		this.kpmgKey = kpmgKey;
	}
	
	public String getKpmgSecret() {
		return kpmgSecret;
	}
	
	public void setKpmgSecret(String kpmgSecret) {
		this.kpmgSecret = kpmgSecret;
	}
	
}
