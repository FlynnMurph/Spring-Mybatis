package com.biz.zq.trans.user;

import com.biz.zq.vo.UserRespVo;
import com.biz.zq.vo.user.resp.SoaUserRespVo;
import com.google.common.base.Function;
import org.springframework.beans.BeanUtils;

public class SoaUserRespVo2UserRespVo implements Function<SoaUserRespVo, UserRespVo>{
    @Override
    public UserRespVo apply(SoaUserRespVo soaUserRespVo) {
        UserRespVo userRespVo = new UserRespVo();
        BeanUtils.copyProperties(soaUserRespVo, userRespVo);
        return userRespVo;
    }
}
