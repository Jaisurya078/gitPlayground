package com.example.simpleProject.advice;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.simpleProject.common.APIResponce;

@RestControllerAdvice
public class ApplicationExceptionHandler 
{


	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleInvalidArgument(MethodArgumentNotValidException ex)
	{
		Map<String,String> errorMap= new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error->{
			errorMap.put(error.getField(),error.getDefaultMessage());
		});
		return errorMap;
	}
	
	@ExceptionHandler(Exception.class)
	public String exception(Exception ex)
	{
		return "Oops There was a problem :"+ex ;
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<APIResponce> accessDeniedException(AccessDeniedException ex)
	{
		APIResponce responce = new  APIResponce();
		responce.setStatus(HttpStatus.UNAUTHORIZED.value());
		return ResponseEntity.status(responce.getStatus()).body(responce);
	}

	
	


}
