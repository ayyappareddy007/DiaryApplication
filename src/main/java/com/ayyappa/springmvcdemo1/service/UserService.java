package com.ayyappa.springmvcdemo1.service;

import com.ayyappa.springmvcdemo1.model.UserModel;

public interface UserService {
	
	UserModel loginService(UserModel userModel);
	
	int registerService(UserModel userModel);

}
