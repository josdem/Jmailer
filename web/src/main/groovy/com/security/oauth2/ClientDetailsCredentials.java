package com.security.oauth2;

import org.springframework.security.oauth2.provider.client.BaseClientDetails;

public interface ClientDetailsCredentials {
	BaseClientDetails getBaseClientDetails(); 
}
