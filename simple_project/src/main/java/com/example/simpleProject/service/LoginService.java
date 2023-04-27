package com.example.simpleProject.service;

import com.example.simpleProject.common.APIResponce;
import com.example.simpleProject.dto.LoginRequestDTO;
import com.example.simpleProject.dto.SignupRequestDTO;
import com.example.simpleProject.entity.User;

public interface LoginService {
	
	public User updateUser(User user);
	public User saveUser(SignupRequestDTO requestDTO);
	public APIResponce login(LoginRequestDTO requestDTO);
}
