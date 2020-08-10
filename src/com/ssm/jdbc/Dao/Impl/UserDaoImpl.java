package com.ssm.jdbc.Dao.Impl;

import com.ssm.jdbc.DTO.UserDto;
import com.ssm.jdbc.Dao.UserDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    //添加用户方法
    @Override
    public int addUser(UserDto userDto) {
        String sql = "insert into user(username,password) value(?,?)";
        Object[] obj = new Object[]{
            userDto.getUsername(),
            userDto.getPassword()
        };
        int num = this.jdbcTemplate.update(sql,obj);
        return num;
    }
    //更新用户方法
    @Override
    public int updateUser(UserDto userDto) {
        String sql = "update user set username=?,password=? where id=?";
        Object[] params = new Object[]{
            userDto.getUsername(),
            userDto.getPassword(),
            userDto.getId()
        };
        int num = this.jdbcTemplate.update(sql,params);
        return num;
    }
    //删除用户方法
    @Override
    public int deleteUser(int id) {
        String sql = "delete from user where id=?";
        int num = this.jdbcTemplate.update(sql,id);
        return id;
    }
    //通过 id 查询用户数据信息
    @Override
    public UserDto selectById(int id) {
        String sql = "select * from user where id=?";
        RowMapper<UserDto> rowMapper = new BeanPropertyRowMapper<UserDto>(UserDto.class);
        return this.jdbcTemplate.queryForObject(sql,rowMapper,id);
    }
    //查询所有用户信息
    @Override
    public List<UserDto> selectAllUser() {
        String sql = "select * from user";
        RowMapper<UserDto> rowMapper = new BeanPropertyRowMapper<UserDto>(UserDto.class);
        return this.jdbcTemplate.query(sql,rowMapper);
    }


}
