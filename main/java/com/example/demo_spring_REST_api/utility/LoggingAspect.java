package com.example.demo_spring_REST_api.utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	public static final Log LOGGER = LogFactory.getLog(LoggingAspect.class);
	
//	@AfterThrowing(pointcut = "execution(* com.tirlok.OneToOne.service.CustomerServiceImpl.* (..))",throwing = "exception")
//	public void logServiceException(Exception exception) {
//		LOGGER.error(exception.getMessage(),exception);
//	}
}
