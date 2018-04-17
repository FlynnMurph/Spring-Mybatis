package com.biz.zq.vo.user.resp;

import java.io.Serializable;

/**
 * @author ZhengQin
 * 用户响应基本类
 */
public class SoaUserRespVo implements Serializable{
    /**
     * id
     */
    private Long id;

    /**
     * 用户账号
     */
    private String userAccount;

    /**
     * 密码  讲道理  整个加密算法
     */
    private String password;

    /**
     * 用户姓名
     */
    private String userName;

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

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
