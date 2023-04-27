package com.example.simpleProject.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simpleProject.common.APIResponce;
import com.example.simpleProject.dto.LoginRequestDTO;
import com.example.simpleProject.dto.SignupRequestDTO;
import com.example.simpleProject.entity.User;
import com.example.simpleProject.repository.LoginRepository;
import com.example.simpleProject.utils.JwtUtils;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	LoginRepository repository;
	
	@Autowired
	JwtUtils jwtUtils;

	public User updateUser(User user) {
		return repository.saveAndFlush(user);
	}

	public User saveUser(SignupRequestDTO requestDTO) {
		
		User user = new User();
		user.setUserName(requestDTO.getUserName());
		user.setAge(requestDTO.getAge());
		user.setGender(requestDTO.getGender());
		user.setPassword(requestDTO.getPassword());
		user.setQualification(requestDTO.getQualification());
		user.setUserType(requestDTO.getUserType());
		return repository.saveAndFlush(user);
		
		}
	
	public APIResponce login(LoginRequestDTO requestDTO) {
		
		APIResponce apiResponce=new APIResponce();
		
		User user= repository.findOneByUserNameAndPassword(requestDTO.getUserName(),requestDTO.getPassword());
		if (user==null) {
			apiResponce.setData("No User Found");
			return apiResponce;
		}
		String token =jwtUtils.generateJwt(user);
		
		Map<String,Object> data = new HashMap<>();
		data.put("accessToken", token);
		
		apiResponce.setData(data);
		
		return apiResponce;
		
	}
	
}
