package com.example.gradruate.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.gradruate.controller.ReadMegController;
import com.example.gradruate.entity.ReadMeg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Mapper
public interface ReadMegMapper extends BaseMapper<ReadMeg> {
    int insertReadMeg(@Param("readMeg") ReadMeg readMeg);

    int updateReadMeg(@Param("uid")String uid);

    List<ReadMeg> queryReadMeg(@Param("uid")String uid);

    int queryUnReadNum(@Param("uid")String uid);

    List<ReadMeg> queryBackReadMeg();
}
