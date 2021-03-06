package com.jos.dem.interceptor

import static org.junit.Assert.*
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations

import com.jos.dem.interceptor.impl.CryptoExceptionInterceptorImpl
import com.jos.dem.service.LoggerService

class TestCryptoExceptionInterceptor {
	
	@InjectMocks
	def interceptor = new CryptoExceptionInterceptorImpl()
	
	@Mock
	LoggerService loggerService
	@Mock
	RuntimeException exception;
	
	def message = "message"
	
	@Before
	void before() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldSendCryptoExceptionMessage() {
		when(exception.getMessage()).thenReturn(message);
		
		interceptor.intercept(exception)
		
		verify(loggerService).notifyRequest(isA(Map.class))
	}

}
