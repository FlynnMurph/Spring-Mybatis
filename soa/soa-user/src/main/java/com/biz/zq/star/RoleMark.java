package com.biz.zq.star;

public enum RoleMark {

    GUEST("guest", "访客"), ADMIN("admin", "管理员"), USER("user", "普通用户");

    RoleMark(String mark, String desc){
        this.mark = mark;
        this.desc = desc;
    }

    /**
     * 标志
     */
    private String mark;

    /**
     * 描述
     */
    private String desc;


    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
