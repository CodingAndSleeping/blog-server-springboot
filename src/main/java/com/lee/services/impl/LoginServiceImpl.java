package com.lee.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.bo.LoginBo;
import com.lee.entity.User;
import com.lee.mapper.LoginMapper;
import com.lee.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, User> implements LoginService {


    @Override
    public boolean valideUser(LoginBo loginBo) {
        QueryWrapper<User> queryMapper = new QueryWrapper<>();
        Map<String, String> map = new HashMap<>();
        map.put("username", loginBo.getUsername());
        map.put("password", loginBo.getPassword());
        queryMapper.allEq(map);

        long count = this.count(queryMapper);

        return count != 0;

    }
}
