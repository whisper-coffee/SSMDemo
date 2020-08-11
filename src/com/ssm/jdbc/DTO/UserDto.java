package com.ssm.jdbc.DTO;

public class UserDto {
    private Integer id;
    private String username;
    private String password;
    private Integer jf;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getJf() {
        return jf;
    }

    public void setJf(Integer jf) {
        this.jf = jf;
    }

    public String toString(){
        return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
    }
}
