package com.usermanagement.service;

import com.usermanagement.model.UserDetail;

public interface UserService {
	public UserDetail createUser(UserDetail user);

	public boolean checkEmail(String email);
}
