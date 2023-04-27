package com.example.simpleProject.utils;
import java.util.*;
import org.springframework.stereotype.Component;

import com.example.simpleProject.advice.AccessDeniedException;
import com.example.simpleProject.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Component
public class JwtUtils 
{
	
	private static String secret="This_Is_Secret";
	private static long expiryDutation=60*60;
	
	public String generateJwt(User user)
	{
		long millTime=System.currentTimeMillis();
		long expiryTime= millTime+ expiryDutation *1000;
		
		Date issuedAt = new Date(millTime);
		Date expiryAt = new Date(expiryTime);
		//claims
		
		Claims claims=Jwts.claims().setIssuer(user.getId().toString())
				.setIssuedAt(issuedAt).setExpiration(expiryAt);
		//optional claims 
		claims.put("UserType",user.getUserType());	
		claims.put("UserName", user.getUserName());
		
		//generate Jwt using claims  
		
		return Jwts.builder()
				.setClaims(claims)
				.signWith(SignatureAlgorithm.HS512,secret) 
				.compact();
	}
	
	public void verify(String authorization)
	{
		try {
			// if key is not valid in this line exception will be thrown .
			Jwts.parser().setSigningKey(secret).parseClaimsJws(authorization);
			
		}catch(Exception ex)
		{
			throw new AccessDeniedException("Access Denied");
		}
		
	}


}
