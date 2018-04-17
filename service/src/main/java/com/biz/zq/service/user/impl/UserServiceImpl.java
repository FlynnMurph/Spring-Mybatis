package com.biz.zq.service.user.impl;

import com.biz.zq.exception.SoaException;
import com.biz.zq.service.SoaUserService;
import com.biz.zq.service.user.UserService;
import com.biz.zq.trans.user.SoaUserRespVo2UserRespVo;
import com.biz.zq.vo.UserRespVo;
import com.biz.zq.vo.user.resp.SoaUserRespVo;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private SoaUserService soaUserService;


    @Override
    public List<UserRespVo> findAll() {
        List<SoaUserRespVo> userRespVos = soaUserService.findAll();
        List<UserRespVo> users = Lists.transform(userRespVos, new SoaUserRespVo2UserRespVo());
        return users;
    }

    @Override
    public UserRespVo getUserByAccount(String account) throws SoaException {
        SoaUserRespVo soaUserRespVo = soaUserService.getUserByAccount(account);
        return new SoaUserRespVo2UserRespVo().apply(soaUserRespVo);
    }
}
