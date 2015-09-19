package com.jos.dem.integration;

import java.util.Map;

public interface MailService {
	void sendMailWithEngine(String email,Map model,String subject,String template);
}
