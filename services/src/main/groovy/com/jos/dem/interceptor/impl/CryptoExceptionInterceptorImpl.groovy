package com.jos.dem.interceptor.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service;

import com.jos.dem.interceptor.CryptoExceptionInterceptor;
import com.jos.dem.service.LoggerService

@Service
class CryptoExceptionInterceptorImpl implements CryptoExceptionInterceptor {

	@Autowired
  LoggerService loggerService


	@Override
	public void intercept(RuntimeException exception) {
		def data = [:]
		data.message = exception.getMessage()
		data.cause = exception.getCause();
		loggerService.notifyRequest(data)
	}
	
}
