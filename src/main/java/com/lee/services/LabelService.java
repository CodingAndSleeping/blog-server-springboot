package com.lee.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.entity.Label;

import java.util.List;

public interface LabelService extends IService<Label> {

    List<Label> getLabels();


}
