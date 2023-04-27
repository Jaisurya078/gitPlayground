package com.example.simpleProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.simpleProject.common.APIResponce;
import com.example.simpleProject.dto.LoginRequestDTO;
import com.example.simpleProject.dto.SignupRequestDTO;
import com.example.simpleProject.entity.User;
import jakarta.validation.Valid;
import com.example.simpleProject.service.*;

@RestController
public class LoginController {

	@Autowired
	private LoginService userService;

	

	@PostMapping("/updateUser")
	public APIResponce updateUser(@RequestBody @Valid User user) throws Exception{
		APIResponce responce =new APIResponce();
		User  updatedUser= userService.updateUser(user);
		
		 if (updatedUser!=null) {
			 responce.setStatus(200);
			 responce.setData(updatedUser);				
			 return responce;
		}else {
			responce.setErrors("No User Found");
			responce.setData(updatedUser);
			return responce;
		}
		
	}
	
	//sign up API
	@PostMapping("/signup")
	public ResponseEntity<User> saveUser(@RequestBody @Valid SignupRequestDTO requestDTO) 
	{
		
		User savedUser = userService.saveUser(requestDTO);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	
	//Login API
	
	@PostMapping("/login")
	public APIResponce login(@RequestBody LoginRequestDTO requestDTO) 
	{
		APIResponce apiResponce=new APIResponce();
		
		apiResponce = userService.login(requestDTO);
		
		return apiResponce;
		
	}

}
