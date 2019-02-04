package com.jpa.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.sample.entity.User;
import com.jpa.sample.service.Impl.UserServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
@Api(tags = "�������� API", value = "�������� API", description = "�������� API")
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	
	@ApiOperation(value = "���� ��Ϻ���")
	@GetMapping(value="/allUsers")
	public ResponseEntity<List<User>> findByAllUsers(){
		
		List<User> users = userServiceImpl.getAllUsers();
		
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@ApiOperation(value = "���� ����ϱ�")
	@PostMapping(value="/saveUser")
	public ResponseEntity<User> saveUser(User user){
		
		User resultUser = userServiceImpl.save(user);
		
		if(resultUser == null) {
			return new ResponseEntity<User>(resultUser, HttpStatus.OK);
		}

		return new ResponseEntity<User>(resultUser, HttpStatus.OK);
	}
	
	@ApiOperation(value = "���� �����ϱ�")
	@DeleteMapping(value="/deleteUser")
	public ResponseEntity<String> deleteUser(Long id){
		
		try {
			userServiceImpl.delete(id);	
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return new ResponseEntity<String>("", HttpStatus.OK);
	}
	
}
