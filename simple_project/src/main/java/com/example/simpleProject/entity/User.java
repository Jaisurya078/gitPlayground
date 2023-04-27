package com.example.simpleProject.entity;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.example.simpleProject.common.Constant;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "user_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_details")
public class User {
	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;
	@Column(name ="user_name",unique = true)
	private String userName;
	
	@Column(name ="password",unique = true)
	private String password;
	
	@Column(name ="age",unique = false)
	@Min(10)
	@Max(80)
	private int age;
	
	@Column(name ="gender",unique =false)
	private String gender=Constant.GENDER.MALE;
	
	@Column(name ="qualification",unique = false)
	private String qualification;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@Column(name="sso_type")
	private String ssoType;
	
	@Column(name="user_type")
	private String userType;
	
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getSsoType() {
		return ssoType;
	}
	public void setSsoType(String ssoType) {
		this.ssoType = ssoType;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	@Column(name ="created_date",unique = true)
	private String createdDate;
	
	@Column(name ="modify_date",unique = true)
	private String modifyDate;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreated_date(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModify_date(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", age=" + age + ", gender="
				+ gender + ", qualification=" + qualification + ", isActive=" + isActive + ", ssoType=" + ssoType
				+ ", userType=" + userType + ", createdDate=" + createdDate + ", modifyDate=" + modifyDate + "]";
	}
	@PrePersist
	public void onSave()
	{
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		  LocalDateTime now = LocalDateTime.now();  
		  this.setModify_date(dtf.format(now));     
	}
	@PostPersist
	public void onUpdate() {
		
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		  LocalDateTime now = LocalDateTime.now();  
		  this.setModify_date(dtf.format(now));  
		
	}
	
}
