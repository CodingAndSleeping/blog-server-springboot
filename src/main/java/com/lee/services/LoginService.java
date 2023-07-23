package com.lee.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.bo.LoginBo;
import com.lee.entity.User;
import com.lee.vo.LoginVo;

public interface LoginService extends IService<User> {
    User login(LoginBo loginBo);
}
