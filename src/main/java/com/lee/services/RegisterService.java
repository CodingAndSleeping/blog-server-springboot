package com.lee.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.entity.User;

public interface RegisterService extends IService<User> {
    boolean ValidateName(String username);

    boolean register(User user);
}
