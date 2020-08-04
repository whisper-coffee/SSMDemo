package com.ssm.bean;

import java.util.List;

public class XmlBeanUser {
    private String userName;
    private String password;
    private List<String> list;

    public XmlBeanUser(){
        super();
    }
    //���췽��ע��
    public XmlBeanUser(String userName, String password, List<String> list){
        super();
        this.userName = userName;
        this.password = password;
        this.list = list;
    }

    // ʹ����ֵע��
    public void setUserName(String userName){
        this.userName = userName;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setList(List<String> list){
        this.list = list;
    }

    @Override
    public String toString(){
        return "XmlBeanUser[userName=" + userName + ",password=" + password + ",list=" + list + "]";
    }

}
