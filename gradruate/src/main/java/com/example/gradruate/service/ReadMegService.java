package com.example.gradruate.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.gradruate.controller.ReadMegController;
import com.example.gradruate.entity.ReadMeg;
import com.example.gradruate.entity.Rotationchart;

import java.util.List;

public interface ReadMegService extends IService<ReadMeg> {
   int insertReadMeg(ReadMeg readMeg);

    int updateReadMeg(String uid);

    List<ReadMeg> queryReadMeg(String uid);

    int queryUnReadNum(String uid);
    List<ReadMeg> queryBackReadMeg();
}
