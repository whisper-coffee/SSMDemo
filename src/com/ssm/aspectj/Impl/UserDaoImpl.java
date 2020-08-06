package com.ssm.aspectj.Impl;

import com.ssm.aspectj.Dao.UserDao;

public class UserDaoImpl implements UserDao{
    @Override
    public void addUser(){
        System.out.println("add user");
    }

    @Override
    public void deleteUser() {
        System.out.println("delete user");
    }
}
