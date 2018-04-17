package com.biz.zq.service.user;

import com.biz.zq.exception.SoaException;
import com.biz.zq.vo.UserRespVo;

import java.util.List;

/**
 * 业务层的service
 * @author ZhengQin
 */
public interface UserService {

    /**
     * 列出所有用户信息
     * @return
     */
    List<UserRespVo> findAll();

    UserRespVo getUserByAccount(String account) throws SoaException;
}
