package com.gaonsoft.mcs.user.dao;

import java.util.List;

import com.gaonsoft.mcs.user.domain.User;
import com.gaonsoft.mcs.user.domain.UserKey;

public interface UserDAO {
	List<User> getAllUsers();
	User getUserById(UserKey id);
	User getUserByUserId(String userId);
	List<User> readAuthority(String UserId);
	
//    void addUser(User user);
//    void updateUser(User user);
//    void deleteUser(int userId);
//    boolean userExists(String id, String name);
}
	