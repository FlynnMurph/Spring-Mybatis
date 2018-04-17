package com.biz.zq.dao.mysql.mapper;

import com.biz.zq.dao.mysql.po.UserInfo;

import java.util.List;

/**
 * 用户信息的mapper
 * @author ZhengQin
 */
public interface UserMapper {

    /**
     * 通过id去查找一个用户
     * @param id
     * @return
     */
    UserInfo getUserById(Long id);

    /**
     * 通过账号去查找一个用户
     * @param userAccount
     * @return
     */
    UserInfo getUserByAccount(String userAccount);

    /**
     * 查找所有的用户
     * @return
     */
    List<UserInfo> findAll();

}
