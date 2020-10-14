package com.ssm.mybatis.test;

import java.io.InputStream;
import java.util.List;

import com.ssm.mybatis.po.User;
import com.sun.org.apache.bcel.internal.generic.ATHROW;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisTest {
    public static void main(String[] args) {
        MyBatisTest myBatisTest = new MyBatisTest();
        try {
            myBatisTest.selectUserById();
            myBatisTest.findUserByName();
            myBatisTest.deleteUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void selectUserById() throws Exception{
        //1.读取配置文件
        String resource = "com/ssm/config/mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        //2.根据配置文件构建 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //3.通过SqlSessionFactory创建SqlSession实例
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.SqlSession执行映射文件中定义的SQL，并返回映射结果
        User user = sqlSession.selectOne("com.ssm.mybatis.mapper.UserMapper.selectUserById",2);
        //5.输出User
        System.out.println(user.toString());
        sqlSession.close();
    }

    public void findUserByName() throws Exception{
        String resource = "com/ssm/config/mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> list = sqlSession.selectList("com.ssm.mybatis.mapper.UserMapper.findUserByName","zhangsan");
        for (User user: list) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    public void insertUser() throws Exception{
        User user = new User();
        user.setUsername("wanglaowu");
        user.setJobs("Maintainer");
        user.setPhone("15227889922");
        String resource = "com/ssm/config/mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int rows = sqlSession.insert("com.ssm.mybatis.mapper.UserMapper.insertUser",user);
        String result = (rows>0)?"插入成功，共插入"+rows+"条数据":"插入失败";
        System.out.println(result);
        sqlSession.commit();
        sqlSession.close();
    }

    public void updateUser() throws Exception{
        User user = new User();
        user.setId(6);
        user.setUsername("wangwu");
        user.setJobs("developer");
        user.setPhone("10293847576");
        String resource = "com/ssm/config/mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int rows = sqlSession.update("com.ssm.mybatis.mapper.UserMapper.updateUser",user);
        String result = (rows>0)?"更改成功":"更改失败";
        System.out.println(result);
        sqlSession.commit();
        sqlSession.close();
    }

    public void deleteUser() throws Exception{
        String resource = "com/ssm/config/mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int rows = sqlSession.delete("com.ssm.mybatis.mapper.UserMapper.deleteUser",3);
        String result = (rows>0)?"删除成功":"删除失败";
        System.out.println(result);
        sqlSession.commit();
        sqlSession.close();
    }
}
