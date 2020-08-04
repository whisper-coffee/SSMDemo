package com.ssm.bean.Impl;

import com.ssm.bean.Dao.AnnotationUserDao;
import org.springframework.stereotype.Repository;

@Repository("annotationUserDao")
//@Repository 将数据访问层（DAO）中的类标记为 Bean
public class AnnotationUserDaoImpl implements AnnotationUserDao {
    public void save(){
        System.out.println("执行annotationUserDao.save()");
    }
}
