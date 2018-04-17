package com.biz.zq.dao.mysql.po;

import com.biz.zq.BaseEntity;
import com.biz.zq.star.RoleMark;

/**
 * 角色 如guest admin之类的
 * @author ZhengQin
 */
public class Role extends BaseEntity{

    /**
     * 角色名称  如管理员  访客
     */
    private String roleName;

    /**
     * 角色标志  guest admin
     */
    private RoleMark roleMark;

    /**
     * 角色等级 对应用户表的level
     */
    private String level;

    /**
     * 可用操作  讲道理  这里要重新设计
     */
    private String work;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public RoleMark getRoleMark() {
        return roleMark;
    }

    public void setRoleMark(RoleMark roleMark) {
        this.roleMark = roleMark;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }
}
