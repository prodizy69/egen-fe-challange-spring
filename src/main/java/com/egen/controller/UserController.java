package com.egen.controller;

import com.egen.ErrorCodes.ErrorCodes;
import com.egen.Pojo.User;
import com.egen.UserResponse.UserResponse;
import com.egen.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/*
 UserController.java, which uses to expose the rest services for User. Create a user, get the users and update the same user with new data
 */

@RestController
public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);

	@ResponseBody
	@RequestMapping(consumes="application/json",
			produces="application/json",value="/createUser",method = RequestMethod.POST)
	public ResponseEntity<UserResponse> createUser(@RequestBody User user){
		User userData= new User();
		UserResponse userResponse =new UserResponse();
		if(user.getId()!=null){
			userData.setId(user.getId());
		}else{
			userData.setId(UUID.randomUUID());
		}

		userData.setFirstName(user.getFirstName());
		userData.setMiddleName(user.getMiddleName());
		userData.setLastName(user.getLastName());
		userData.setGender(user.getGender());
		userData.setAge(user.getAge());
		userData.setPhone(user.getPhone());
		userData.setZip(user.getZip());
		UserService userservice= new UserService();
		userResponse =userservice.createUser(userData);

		logger.info("UserData is  :"+user);
		if(userResponse.getErrorCode()== ErrorCodes.ERROR_CODE_CREATE_USER_1){
			return new ResponseEntity<UserResponse>(userResponse, HttpStatus.EXPECTATION_FAILED);
		}

		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
	}
	@RequestMapping(value = "/getUsers",method = RequestMethod.GET)
	public ResponseEntity<UserResponse> getUsers() {
		UserResponse  userResponse =new UserResponse();

		UserService userservice= new UserService();
		userResponse =userservice.getUsers();
		logger.info("Users List is  :"+userResponse);
		return new ResponseEntity<UserResponse>(userResponse,HttpStatus.OK);
	}
	@RequestMapping(value = "/updateUser",method = RequestMethod.POST)
	public ResponseEntity<UserResponse> updateUser(@RequestBody User model, HttpServletRequest req) {
		UserService userservice= new UserService();
		UserResponse updateUserResponse = new UserResponse();
		updateUserResponse =userservice.updateUser(model);
		logger.info("Updated user data  is  :"+updateUserResponse);
		if(updateUserResponse.getErrorCode()==ErrorCodes.ERROR_CODE_UPDATE_USERS_2){
			return new ResponseEntity<UserResponse>(updateUserResponse,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UserResponse>(updateUserResponse,HttpStatus.OK);

	}
}
