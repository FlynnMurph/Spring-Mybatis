package com.biz.zq.service;

import com.biz.zq.baseservice.AbstractBaseService;
import com.biz.zq.dao.mysql.mapper.UserMapper;
import com.biz.zq.dao.mysql.po.UserInfo;
import com.biz.zq.exception.ApiException;
import com.biz.zq.exception.SoaException;
import com.biz.zq.trans.UserInfo2SoaUserRespVo;
import com.biz.zq.vo.user.resp.SoaUserRespVo;
import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZhengQin
 * 用户服务实现
 */
@Service
public class SoaUserServiceImpl extends AbstractBaseService implements SoaUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<SoaUserRespVo> findAll() {
        List<UserInfo> userInfos = userMapper.findAll();
        List<SoaUserRespVo> soaUserRespVos = Lists.transform(userInfos, new UserInfo2SoaUserRespVo());

        return soaUserRespVos;
    }

    @Override
    public SoaUserRespVo getUserByAccount(String account) throws SoaException {

        if (StringUtils.isEmpty(account)) {
            return null;
        }
        SoaUserRespVo soaUserRespVo = new SoaUserRespVo();
        UserInfo userInfo = userMapper.getUserByAccount(account);
        if (userInfo == null) {
            throw new SoaException(ApiException.User.USER_MOT_EXIST.getCode(), ApiException.User.USER_MOT_EXIST.getDescription());
        }
        soaUserRespVo = new UserInfo2SoaUserRespVo().apply(userInfo);
        return soaUserRespVo;
    }
}
