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
        //���������ļ�
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        //��ȡ JdbcTemplate ʵ��
        JdbcTemplate jdbcTemplate = (JdbcTemplate)applicationContext.getBean("jdbcTemplate");
        // execute() ������ִ�� sql ��䣬�����û��� user
        jdbcTemplate.execute("create table user(id int primary key auto_increment,username varchar(40),password varchar(40))");
        //��
        addUserTest(applicationContext);
        //ɾ
        deleteUserTest(applicationContext);
        //��
        updateUserTest(applicationContext);
        //�����
        selectUserById(applicationContext);
        //��ȫ��
        selectAllUser(applicationContext);
    }

    public static void addUserTest(ApplicationContext applicationContext){
        //��ȡ�û�ʵ��
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");
        //���� UserDto ʵ��
        UserDto userDto = new UserDto();
        //���� UserDto ����ֵ
        userDto.setUsername("ckevin");
        userDto.setPassword("123456");
        //�����û�
        int num = userDao.addUser(userDto);
        System.out.println(num>0?"�ɹ�����"+num+"������\n"+userDto.toString():"����ʧ��");
    }

    public static void updateUserTest(ApplicationContext applicationContext){
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setUsername("ckevin");
        userDto.setPassword("111111");
        int num = userDao.updateUser(userDto);
        System.out.println(num>0?"�ɹ��޸�"+num+"������\n"+userDto.toString():"����ʧ��");
    }

    public static void deleteUserTest(ApplicationContext applicationContext){
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");
        UserDto userDto = new UserDto();
        userDto.setId(1);
        int num = userDao.deleteUser(userDto.getId());
        System.out.println(num>0?"�ɹ�ɾ��"+num+"������":"����ʧ��");
    }

    private static void selectUserById(ApplicationContext applicationContext) {
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");
        //ͨ�� id ��ѯ�û���Ϣ
        UserDto userDto = userDao.selectById(2);
        System.out.println(userDto);
    }

    private static void selectAllUser(ApplicationContext applicationContext) {
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");
        //��ѯ�����û���Ϣ
        List<UserDto> list = userDao.selectAllUser();
        //ѭ�����
        for (UserDto userdto:list) {
            System.out.println(userdto);
        }
    }
}
