package com.ssm.ioc_di.Impl;

import com.ssm.ioc_di.UserDao;
import com.ssm.ioc_di.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    public void login(){
        this.userDao.login();
        System.out.println("userService login");
    }
}
