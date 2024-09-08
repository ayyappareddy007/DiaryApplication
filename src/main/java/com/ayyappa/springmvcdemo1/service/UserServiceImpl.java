package com.ayyappa.springmvcdemo1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayyappa.springmvcdemo1.model.UserModel;
import com.ayyappa.springmvcdemo1.repo.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Override
	public UserModel loginService(UserModel userModel) {
		return userDao.isExist(userModel);
	}

	@Override
	public int registerService(UserModel userModel) {
		return userDao.register(userModel);
	}

}
