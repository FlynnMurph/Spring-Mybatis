package com.biz.zq.controller;

import cn.hutool.json.JSONUtil;
import com.biz.zq.exception.SoaException;
import com.biz.zq.result.CommonResult;
import com.biz.zq.service.user.UserService;
import com.biz.zq.vo.UserRespVo;
import com.biz.zq.vo.user.req.LoginReqVo;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    @ResponseBody
    public String findAll() {
        List<UserRespVo> respVos = userService.findAll();
        String str = JSONUtil.toJsonStr(respVos);
        System.out.println(str);
        return JSONUtil.toJsonStr(respVos);
    }

    @RequestMapping(value = "/loginUser")
    @ResponseBody
    public String loginSystem(LoginReqVo loginReqVo) throws SoaException {
        if (loginReqVo != null) {
            UserRespVo userRespVo = userService.getUserByAccount(loginReqVo.getUserAccount());
            if (userRespVo == null) {
                return JSONUtil.toJsonStr(new CommonResult(-2, "用户不存在！"));
            } else {
                if (StringUtils.equals(loginReqVo.getPassword(), userRespVo.getPassword())) {
                    return JSONUtil.toJsonStr(new CommonResult(0, "登录成功"));
                } else {
                    return JSONUtil.toJsonStr(new CommonResult(-3, "密码错误"));
                }
            }
        } else {
            return JSONUtil.toJsonStr(new CommonResult(-1, "请输入账号密码！"));
        }
    }

    @RequestMapping("/login")
    public ModelAndView goLogin(){
        return new ModelAndView("login");
    }
}
