package com.easytolearn.crud.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.CodeSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Aspect
@Controller
public class LoggingAspect {
	
	public final static Logger log = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution(* com.easytolearn.crud.*.*(..))")
	public void controllerBefore(JoinPoint joinPoint){
		log.info(" Request is "+getClassMetadata(joinPoint));	
	}
	
	@AfterReturning("execution(* com.easytolearn.crud.*.*(..))")
	public void controllerAfter(JoinPoint joinPoint){
		log.info(" Response is "+getClassMetadata(joinPoint));	
	}
	
	@Before("execution(* com.easytolearn.crud.service.*.*(..))")
	public void serviceBefore(JoinPoint joinPoint){
		log.info(" Service class "+getClassMetadata(joinPoint));	
	}
	
	private String getClassMetadata(JoinPoint jp) {
		CodeSignature signature = (CodeSignature) jp.getSignature();
		StringBuilder builder = new StringBuilder();
		for(int i = 0 ; i < jp.getArgs().length ; i ++) {
			builder.append(signature.getParameterNames()[i]);
			builder.append(": ");
			builder.append(jp.getArgs()[i].toString());
			builder.append(" ");
		}
		return builder.toString();
	}
	
}
