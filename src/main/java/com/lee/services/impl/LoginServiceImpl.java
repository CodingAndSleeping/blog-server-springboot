package com.lee.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.bo.LoginBo;
import com.lee.entity.User;
import com.lee.mapper.LoginMapper;
import com.lee.services.LoginService;
import com.lee.utils.JWTUtil;
import com.lee.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, User> implements LoginService {


    @Override
    public User login(LoginBo loginBo) {
        QueryWrapper<User> queryMapper = new QueryWrapper<>();
        Map<String, String> map = new HashMap<>();
        map.put("username", loginBo.getUsername());
        map.put("password", loginBo.getPassword());
        queryMapper.allEq(map);

        return this.getOne(queryMapper);



    }
}
