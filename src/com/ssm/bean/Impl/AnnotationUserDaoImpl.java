package com.ssm.bean.Impl;

import com.ssm.bean.Dao.AnnotationUserDao;
import org.springframework.stereotype.Repository;

@Repository("annotationUserDao")
//@Repository �����ݷ��ʲ㣨DAO���е�����Ϊ Bean
public class AnnotationUserDaoImpl implements AnnotationUserDao {
    public void save(){
        System.out.println("ִ��annotationUserDao.save()");
    }
}
