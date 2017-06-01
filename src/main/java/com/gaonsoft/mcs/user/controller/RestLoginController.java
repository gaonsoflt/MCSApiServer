package com.gaonsoft.mcs.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gaonsoft.mcs.common.BBCrypto;
import com.gaonsoft.mcs.common.util.gaonnova.ConstType;
import com.gaonsoft.mcs.common.util.gaonnova.SimpleCrypto;
import com.gaonsoft.mcs.user.domain.AuthenticationToken;
import com.gaonsoft.mcs.user.domain.User;
import com.gaonsoft.mcs.user.service.UserService;

@RestController
@RequestMapping("/api/users")
public class RestLoginController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@RequestMapping(value="/login", method = RequestMethod.POST) 
	public ResponseEntity<AuthenticationToken> doLogin(@RequestBody final User user, HttpSession session) {
		if(user == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		String id = BBCrypto.decrypt(user.getUserId());
		String pw = SimpleCrypto.aesEncrypt(ConstType.AESKEY_LOGIN.key, BBCrypto.decrypt(user.getLoginPwd()));
		
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(id, pw);
        Authentication authentication = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());

		final User result = userService.getUserByUserId(id);
		if (result == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		AuthenticationToken _token = new AuthenticationToken(result.getUserId(), result.getUserNm(), result.getAuthorities(), session.getId());
		return new ResponseEntity<AuthenticationToken>(_token, HttpStatus.OK);
	}
}
