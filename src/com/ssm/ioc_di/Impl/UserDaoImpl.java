package com.ssm.ioc_di.Impl;

import com.ssm.ioc_di.UserDao;

public class UserDaoImpl implements UserDao {
    public void login(){
        System.out.println("UserDao login");
    }
}
