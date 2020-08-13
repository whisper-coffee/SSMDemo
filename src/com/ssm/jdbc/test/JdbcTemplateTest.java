package com.ssm.jdbc.test;

import com.ssm.jdbc.DTO.UserDto;
import com.ssm.jdbc.Dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcTemplateTest {
    public static void main(String[] args) {
        String xmlPath = "com/ssm/config/applicationContextJdbcXml.xml";
        //加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        //获取 JdbcTemplate 实例
        JdbcTemplate jdbcTemplate = (JdbcTemplate)applicationContext.getBean("jdbcTemplate");
        // execute() 方法，执行 sql 语句，创建用户表 user
        jdbcTemplate.execute("create table user(id int primary key auto_increment,username varchar(40),password varchar(40))");
        //增
        addUserTest(applicationContext);
        //删
        deleteUserTest(applicationContext);
        //改
        updateUserTest(applicationContext);
        //查个体
        selectUserById(applicationContext);
        //查全体
        selectAllUser(applicationContext);
    }

    public static void addUserTest(ApplicationContext applicationContext){
        //获取用户实例
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");
        //创建 UserDto 实例
        UserDto userDto = new UserDto();
        //设置 UserDto 属性值
        userDto.setUsername("ckevin");
        userDto.setPassword("123456");
        //增加用户
        int num = userDao.addUser(userDto);
        System.out.println(num>0?"成功插入"+num+"条数据\n"+userDto.toString():"插入失败");
    }

    public static void updateUserTest(ApplicationContext applicationContext){
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setUsername("ckevin");
        userDto.setPassword("111111");
        int num = userDao.updateUser(userDto);
        System.out.println(num>0?"成功修改"+num+"条数据\n"+userDto.toString():"插入失败");
    }

    public static void deleteUserTest(ApplicationContext applicationContext){
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");
        UserDto userDto = new UserDto();
        userDto.setId(1);
        int num = userDao.deleteUser(userDto.getId());
        System.out.println(num>0?"成功删除"+num+"条数据":"插入失败");
    }

    private static void selectUserById(ApplicationContext applicationContext) {
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");
        //通过 id 查询用户信息
        UserDto userDto = userDao.selectById(2);
        System.out.println(userDto);
    }

    private static void selectAllUser(ApplicationContext applicationContext) {
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");
        //查询所有用户信息
        List<UserDto> list = userDao.selectAllUser();
        //循环输出
        for (UserDto userdto:list) {
            System.out.println(userdto);
        }
    }
}
