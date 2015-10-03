package com.jos.dem.advice

import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.aspectj.lang.annotation.AfterThrowing
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component
import java.lang.RuntimeException

@Component
@Aspect
class AfterThrowingAdvice {

  @AfterThrowing(pointcut = "execution(* com.jos.dem.controller..**.*(..))", throwing = "ex")
  def doRecoveryActions(RuntimeException ex){
    log.info "Wrapping exception ${ex.message}"
  }

}
