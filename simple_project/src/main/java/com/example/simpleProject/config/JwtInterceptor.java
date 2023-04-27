package com.example.simpleProject.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.simpleProject.utils.JwtUtils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor  implements HandlerInterceptor{
	
	@Autowired
	private JwtUtils jwtUtils;
		
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String auth=request.getHeader("authorization");
		
		if (!request.getRequestURI().contains("login")||(request.getRequestURI().contains("signup"))) {
			
			jwtUtils.verify(auth);
		}

		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}