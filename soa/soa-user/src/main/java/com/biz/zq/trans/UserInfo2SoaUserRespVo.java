package com.biz.zq.trans;

import com.biz.zq.dao.mysql.po.UserInfo;
import com.biz.zq.vo.user.resp.SoaUserRespVo;
import com.google.common.base.Function;


public class UserInfo2SoaUserRespVo implements Function<UserInfo, SoaUserRespVo> {
    @Override
    public SoaUserRespVo apply(UserInfo userInfo) {
        SoaUserRespVo soaUserRespVo = new SoaUserRespVo();
        soaUserRespVo.setId(userInfo.getId());
        soaUserRespVo.setUserName(userInfo.getUserName());
        soaUserRespVo.setUserAccount(userInfo.getUserAccount());
        soaUserRespVo.setPassword(userInfo.getPassword());
        return soaUserRespVo;
    }
}
