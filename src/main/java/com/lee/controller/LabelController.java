package com.lee.controller;

import com.lee.common.Result;
import com.lee.entity.Label;
import com.lee.services.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LabelController {
    @Autowired
    private LabelService labelService;

    @Autowired
    private RedisTemplate redisTemplate;
    
    @GetMapping("/getLabels")
    public Result<?> home(){
        List<Label> labels = labelService.getLabels();
        redisTemplate.opsForValue().set("labels",labels);
       return Result.success(labels);
    }

}
