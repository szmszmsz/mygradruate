package com.example.gradruate.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.gradruate.entity.Messagetable;
import com.example.gradruate.entity.Rotationchart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface RotationchartService extends IService<Rotationchart> {
    Map<String, String> uploadRation(MultipartFile file);

    void saveUrl(Rotationchart rotationchart);

    List<Rotationchart> qureyAllPicture();

    int del(String pictrueName);
}
