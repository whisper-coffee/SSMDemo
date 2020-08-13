package com.ssm.mybatis.test;

import java.io.InputStream;
import com.ssm.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisTest {
    public static void main(String[] args) {
        MyBatisTest myBatisTest = new MyBatisTest();
        try {
            myBatisTest.selectUserById();
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
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("com.ssm.mybatis.mapper.UserMapper.selectUserById",2);
        System.out.println(user.toString());
        sqlSession.close();
    }
}
