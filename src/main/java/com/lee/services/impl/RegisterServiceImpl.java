package com.lee.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.entity.User;
import com.lee.mapper.RegisterMapper;
import com.lee.services.RegisterService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl extends ServiceImpl<RegisterMapper, User> implements RegisterService {
    @Override
    public boolean ValidateName(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(StringUtils.isNotBlank(username), "username", username);
        User user = this.getOne(queryWrapper);
        return user != null;
    }

    @Override
    public boolean register(User user) {

        return this.save(user);
    }
}
