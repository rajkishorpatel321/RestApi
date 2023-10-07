package com.example.demo_spring_REST_api.utility;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo_spring_REST_api.exception.InfyBankException;

@RestControllerAdvice
public class ExceptionControllerAdvice {

	@Autowired
	Environment enviroment;
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> exceoptionHandler(Exception exception){
		ErrorInfo error = new ErrorInfo();
		error.setErrorMessage(enviroment.getProperty("Gernal.EXCEPTION_MESSAGE"));
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(InfyBankException.class)
	public ResponseEntity<ErrorInfo> infyBancExceptionHandler(InfyBankException exception){
		ErrorInfo error = new ErrorInfo();
		int value = HttpStatus.NOT_FOUND.value();
		error.setErrorCode(value);
		error.setErrorMessage("Infy bank exception");
		error.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorInfo> exceoptionHandler(MethodArgumentNotValidException exception){
		ErrorInfo error = new ErrorInfo();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		 String errorString = exception.getBindingResult().getAllErrors().stream().
				             map(x-> x.getDefaultMessage()).collect(Collectors.joining(" ,"));
		
		error.setErrorMessage(errorString);
		error.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(error,HttpStatus.BAD_REQUEST);
	}
	
}












