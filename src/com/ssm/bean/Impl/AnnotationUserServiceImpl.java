package com.ssm.bean.Impl;

import com.ssm.bean.Dao.AnnotationUserDao;
import com.ssm.bean.Service.AnnotationUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("annotationUserService")
//@Service ��ҵ��㣨Service��������Ϊ Bean
public class AnnotationUserServiceImpl implements AnnotationUserService {
    @Resource(name="annotationUserDao")
    private AnnotationUserDao annotationUserDao;
    public void save(){
        this.annotationUserDao.save();
        System.out.println("ִ��annotationUserService.save()");
    }
}
