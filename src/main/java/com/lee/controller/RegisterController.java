package com.lee.controller;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.uuid.UUIDComparator;
import com.fasterxml.uuid.UUIDGenerator;
import com.fasterxml.uuid.impl.UUIDUtil;
import com.lee.common.Result;
import com.lee.entity.User;
import com.lee.services.RegisterService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @PostMapping("/validateName/{username}")
    public Result<?> validateName(@PathVariable String username){
        boolean val = registerService.ValidateName(username);
        if(val){
            return Result.error("用户名已存在！");

        }
        return Result.success();

    }
    @PostMapping("/register")
    public Result<?> register(@RequestBody User user){
        UUID uuid = UUID.randomUUID();

        long leastSignificantBits = uuid.getLeastSignificantBits();
        user.setId(Long.toString(leastSignificantBits));

        boolean val = registerService.register(user);

        if(val){
            return Result.success("注册成功！");
        }
        return Result.error("注册失败！");

    }
}
