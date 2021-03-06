package com.easytolearn.crud.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Aspect
@Controller
public class LoggingAspect {
	
	public final static Logger log = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution(* com.easytolearn.crud.*.*(..))")
	public void before(JoinPoint joinPoint){
		log.info(" Request is"+joinPoint);	
	}
	
}
