package com.example.simpleProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.simpleProject.dto.SignupRequestDTO;
import com.example.simpleProject.entity.User;

@Repository
public interface LoginRepository extends JpaRepository<User, Integer>
{

	User findOneByUserNameAndPassword(String userName, String password);

}
