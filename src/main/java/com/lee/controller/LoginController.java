package com.lee.controller;

import com.lee.bo.LoginBo;
import com.lee.common.Result;
import com.lee.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public Result login(@RequestBody LoginBo loginBo) {
        boolean val = loginService.valideUser(loginBo);
        if(val){
            return Result.success("登陆成功");
        }else {
            return Result.error("用户名或密码错误！");
        }


    }
}
