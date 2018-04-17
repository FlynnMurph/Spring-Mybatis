package com.biz.zq.vo;

public class UserRespVo {

    /**
     * id
     */
    private Long id;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
