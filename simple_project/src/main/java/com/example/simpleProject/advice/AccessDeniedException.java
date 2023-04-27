package com.example.simpleProject.advice;

public class AccessDeniedException extends RuntimeException
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccessDeniedException(String ex)
	{
		super(ex);
	}
	

}
