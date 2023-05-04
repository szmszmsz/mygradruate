package com.example.gradruate.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface OssService {
    //上传头像到oss
    Map<String,String> uploadFileAvatar(MultipartFile file);

    //根据图片名字删除OSS存储的文件
    void deleteOSSPictrueByName(String pictrueName);
}
