package com.ssm.bean.Controller;

import com.ssm.bean.Service.AnnotationUserService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller("annotationUserController")
//@Controller 将控制层（Controller）的类标记为Bean
public class AnnotationUserController {
    @Resource(name="annotationUserService")
    private AnnotationUserService annotationUserService;
    public void save(){
        this.annotationUserService.save();
        System.out.println("执行annotationController.save()");
    }
}
