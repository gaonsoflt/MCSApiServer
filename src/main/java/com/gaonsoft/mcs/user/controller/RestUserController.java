package com.gaonsoft.mcs.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gaonsoft.mcs.user.domain.User;
import com.gaonsoft.mcs.user.service.UserService;

@RestController
@RequestMapping("/api/users")
public class RestUserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET) 
	public ResponseEntity<List<User>> selectAllUsers() {
		final List<User> result = userService.getAllUsers();
		if (result.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET) 
	public ResponseEntity<User> selectUserByUserId(@PathVariable(name="userId") String userId) {
		final User result = userService.getUserByUserId(userId);
		if (result == null) {
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<User>(result, HttpStatus.OK);
	}
	
//	@RequestMapping(value = "/users/login", method = RequestMethod.POST) 
//	public ResponseEntity<User> doLogin(@RequestBody final User user) {
//		if(user == null) {
//			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
//		}
//		final User result = userService.doLogin(user.getUserId(), user.getLoginPwd());
//		if (result == null) {
//			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
//		}
//		
//		return new ResponseEntity<User>(result, HttpStatus.OK);
//	}
}
