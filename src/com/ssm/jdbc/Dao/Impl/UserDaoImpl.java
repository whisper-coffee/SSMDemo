package com.ssm.jdbc.Dao.Impl;

import com.ssm.jdbc.DTO.UserDto;
import com.ssm.jdbc.Dao.UserDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Repository("userDao")//ʹ��ע���Զ�ɨ����Ҫ��ע��
public class UserDaoImpl implements UserDao {
    @Resource(name="jdbcTemplate")//ʹ��ע���Զ�ɨ����Ҫ��ע��
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    //����û�����
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
    //�����û�����
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
    //ɾ���û�����
    @Override
    public int deleteUser(int id) {
        String sql = "delete from user where id=?";
        int num = this.jdbcTemplate.update(sql,id);
        return id;
    }
    //ͨ�� id ��ѯ�û�������Ϣ
    @Override
    public UserDto selectById(int id) {
        String sql = "select * from user where id=?";
        RowMapper<UserDto> rowMapper = new BeanPropertyRowMapper<UserDto>(UserDto.class);
        return this.jdbcTemplate.queryForObject(sql,rowMapper,id);
    }
    //��ѯ�����û���Ϣ
    @Override
    public List<UserDto> selectAllUser() {
        String sql = "select * from user";
        RowMapper<UserDto> rowMapper = new BeanPropertyRowMapper<UserDto>(UserDto.class);
        return this.jdbcTemplate.query(sql,rowMapper);
    }

    //����������ʱ���Ƚ��ջ��֣�������Ϊ�쳣δ���ͳ�ȥ������������У������쳣ǰ��Ӧ�ñ��ֲ���
    @Override
    @Transactional(propagation= Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false)
    public void transfer(String outUser, String inUser, Integer jf) {
        //���ջ���
        this.jdbcTemplate.update("update user set jf=jf+? where username=?",jf,inUser);
        //ģ��ϵͳ�����쳣
        int i = 1/0;
        //���ͻ���
        this.jdbcTemplate.update("update user set jf=jf-? where username=?",jf,outUser);
    }

}
