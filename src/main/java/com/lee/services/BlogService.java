package com.lee.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.bo.BlogBo;
import com.lee.entity.Blog;
import com.lee.vo.BlogVo;

import java.util.List;

public interface BlogService extends IService<Blog> {
    BlogVo getBlogs(BlogBo blogBo);
}
