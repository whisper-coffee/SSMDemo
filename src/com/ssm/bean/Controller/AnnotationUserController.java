package com.ssm.bean.Controller;

import com.ssm.bean.Service.AnnotationUserService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller("annotationUserController")
//@Controller �����Ʋ㣨Controller��������ΪBean
public class AnnotationUserController {
    @Resource(name="annotationUserService")
    private AnnotationUserService annotationUserService;
    public void save(){
        this.annotationUserService.save();
        System.out.println("ִ��annotationController.save()");
    }
}
