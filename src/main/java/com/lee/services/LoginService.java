package com.lee.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.bo.LoginBo;
import com.lee.entity.User;

public interface LoginService extends IService<User> {
    boolean valideUser(LoginBo loginBo);
}
