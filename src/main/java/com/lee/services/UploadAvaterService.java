package com.lee.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.entity.User;

public interface UploadAvaterService extends IService<User> {

    boolean uploadAvater(String username, String avater);
}
