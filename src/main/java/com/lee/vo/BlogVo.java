package com.lee.vo;


import com.lee.entity.Blog;
import lombok.Data;

import java.util.List;

@Data
public class BlogVo {

    private List<Blog> blogList;

    private long total;
}
