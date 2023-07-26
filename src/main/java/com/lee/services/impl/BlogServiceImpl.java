package com.lee.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.bo.BlogBo;
import com.lee.entity.Blog;
import com.lee.mapper.BlogMapper;
import com.lee.services.BlogService;
import com.lee.vo.BlogVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {
    @Override
    public BlogVo getBlogs(BlogBo blogBo) {
        QueryWrapper<Blog> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(blogBo.getLabel()), "labels", blogBo.getLabel());

        queryWrapper.like(StringUtils.isNotBlank(blogBo.getKeywords()), "title", blogBo.getKeywords());
        queryWrapper.orderByDesc("create_time");
        Page<Blog> page = new Page<>(blogBo.getPage(), blogBo.getPageSize());

        Page<Blog> blogPage = this.page(page, queryWrapper);
        BlogVo blogVo = new BlogVo();
        blogVo.setBlogList(blogPage.getRecords());
        blogVo.setTotal(blogPage.getTotal());

        return blogVo;
    }
}
