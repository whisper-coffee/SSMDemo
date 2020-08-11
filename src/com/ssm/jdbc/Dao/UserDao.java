package com.ssm.jdbc.Dao;

import com.ssm.jdbc.DTO.UserDto;

import java.util.List;

public interface UserDao {
    int addUser(UserDto userDto);
    int updateUser(UserDto userDto);
    int deleteUser(int id);
    UserDto selectById(int id);
    List<UserDto> selectAllUser();
    //ÔùËÍ»ý·Ö
    void transfer(String outUser, String inUser, Integer jf);
}
