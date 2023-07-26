package com.lee.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterMapper  extends BaseMapper<User> {

}
