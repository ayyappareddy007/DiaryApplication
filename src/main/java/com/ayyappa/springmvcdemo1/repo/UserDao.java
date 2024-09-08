package com.ayyappa.springmvcdemo1.repo;

import com.ayyappa.springmvcdemo1.model.UserModel;

public interface UserDao {
	UserModel isExist(UserModel userModel);
	int register(UserModel userModel);

}
