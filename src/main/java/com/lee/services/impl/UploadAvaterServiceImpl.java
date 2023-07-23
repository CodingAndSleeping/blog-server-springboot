package com.lee.services.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.entity.User;
import com.lee.mapper.UploadAvaterMapper;
import com.lee.services.UploadAvaterService;
import org.springframework.stereotype.Service;

@Service
public class UploadAvaterServiceImpl extends ServiceImpl<UploadAvaterMapper, User> implements UploadAvaterService {
    @Override
    public boolean uploadAvater(String username, String avater) {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("username", username);
        updateWrapper.set("avater", avater);
        return this.update(updateWrapper);
    }

}
