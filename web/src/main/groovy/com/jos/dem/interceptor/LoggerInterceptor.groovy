package com.jos.dem.interceptor

import groovy.transform.AutoClone;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView

import com.fasterxml.jackson.databind.Module.SetupContext;
import com.jos.dem.service.LoggerService
import com.jos.dem.service.StringSplitter
import com.jos.dem.service.impl.StringSplitterImpl;
import com.jos.dem.state.ApplicationState;

class LoggerInterceptor implements HandlerInterceptor {

	@Autowired
  LoggerService loggerService
	@Autowired
	Properties dynamic
	@Autowired
	StringSplitter splitter
	
	def whiteList = []
	
	@PostConstruct
	public void setup(){
		whiteList = splitter.split(dynamic.getProperty(ApplicationState.WHITE_LIST))
	}
	
  boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
  	def data = [:]
  	data.remoteHost = request.remoteHost
  	data.timeInMillis = System.currentTimeMillis()
  	data.method = request.method
  	data.requestURL = request.requestURL
  	data.parameters = request.parameterMap

		if(!whiteList.contains(request.remoteHost)){
			data.warn = "UNAUTORIZED IP was detected in attempt to access to resource"
			loggerService.notifyRequest(data)
			return false;
		}
		
  	loggerService.notifyRequest(data)
    return true
  }


  void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
  }


  void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
  }

}
