package com.lee.controller;


import com.lee.bo.BlogBo;
import com.lee.common.Result;
import com.lee.entity.Blog;
import com.lee.services.BlogService;
import com.lee.vo.BlogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/getBlogs")
    public Result getBlogs(BlogBo blogBo) {

        return Result.success(blogService.getBlogs(blogBo));
    }
}
