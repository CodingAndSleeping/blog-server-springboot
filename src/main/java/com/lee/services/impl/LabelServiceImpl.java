package com.lee.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.entity.Label;
import com.lee.mapper.LabelMapper;
import com.lee.services.LabelService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelServiceImpl extends ServiceImpl<LabelMapper, Label>  implements LabelService {

    @Override
    @Cacheable("labels")
    public List<Label> getLabels() {
        List<Label> labels = this.list();
        return labels;
    }
}
