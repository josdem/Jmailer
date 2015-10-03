package com.jos.dem.advice

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterThrowingAdvice {

  private Log log = LogFactory.getLog(AfterThrowingAdvice.class);

  // Look ma! I'm catching exceptions with AOP !!!
  @AfterThrowing(pointcut="execution(* com.jos.dem.controller.**.*(..))",throwing="customNameException")
  public void afterReturningMethod(JoinPoint joinPoint, RuntimeException customNameException) {
    StringBuffer buffer = new StringBuffer("Ha ocurrido un error en " + joinPoint.getSignature().getName() + " ");
    buffer.append("de " + joinPoint.getTarget().getClass().getName() + " - Argumentos:");
    for(Object o:joinPoint.getArgs()){
      buffer.append(o + " ");
    }
    buffer.append(" y el error " + customNameException.getMessage());
    log.error(buffer.toString());
  }

}

