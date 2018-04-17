package com.biz.zq.service;

import com.biz.zq.exception.SoaException;
import com.biz.zq.vo.user.resp.SoaUserRespVo;

import java.util.List;

/**
 * 用户服务接口
 * @author ZhengQin
 */
public interface SoaUserService {

    /**
     * 列出所有的用户
     * @return
     */
    List<SoaUserRespVo> findAll();

    /**
     * 通过账号去查找用户
     * @param account
     * @return
     */
    SoaUserRespVo getUserByAccount(String account) throws SoaException;
}
