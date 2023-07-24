package com.lee.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Blog {

    @TableId
    private String id;

    private String title;

    private String content;

    @TableField("create_time")
    private String createTime;

    private String username;

    private String labels;

    private long views;

    private long likes;
}
