package com.ssm.aspectj.Impl;

import com.ssm.aspectj.Dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository("userDao")
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
