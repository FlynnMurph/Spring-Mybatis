package com.biz.zq.vo.user.req;

/**
 * 登录请求类
 * @author ZhengQin
 */
public class LoginReqVo {

    /**
     * 账号
     */
    private String userAccount;

    /**
     * 密码
     */
    private String password;

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
