package com.ssm.bean.Impl;

import com.ssm.bean.Dao.AnnotationUserDao;
import com.ssm.bean.Service.AnnotationUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("annotationUserService")
//@Service 将业务层（Service）的类标记为 Bean
public class AnnotationUserServiceImpl implements AnnotationUserService {
    @Resource(name="annotationUserDao")
    private AnnotationUserDao annotationUserDao;

    //自动装配需要用到 setter() 方法
    public void setAnnotationUserDao(AnnotationUserDao annotationUserDao){
        this.annotationUserDao = annotationUserDao;
    }

    public void save(){
        this.annotationUserDao.save();
        System.out.println("执行annotationUserService.save()");
    }
}
