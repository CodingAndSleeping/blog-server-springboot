package com.lee.controller;

import com.lee.bo.LoginBo;
import com.lee.common.Result;
import com.lee.entity.User;
import com.lee.services.LoginService;
import com.lee.utils.JWTUtil;
import com.lee.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {


    @Autowired
    private LoginService loginService;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/login")
    public Result<?> login(@RequestBody LoginBo loginBo) {
        User user = loginService.login(loginBo);
        if(user != null){
            LoginVo loginVo = new LoginVo();
            loginVo.setId(user.getId());
            loginVo.setToken(jwtUtil.generateToken(user.getUsername()));
            loginVo.setAvater(user.getAvater());
            return Result.success("登陆成功",loginVo);
        }else {
            return Result.error("用户名或密码错误！");
        }
    }
}
