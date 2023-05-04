package com.example.gradruate.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.gradruate.entity.Rotationchart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RotationchartMapper extends BaseMapper<RotationchartMapper> {
    int insertRotationchart(@Param("url") String url,@Param("fileName") String fileName);

    List<Rotationchart> qureyAllPicture();

    int del(@Param("pictrueName")String pictrueName);

//    int saveUrl(@Param("Rotaionchart") Rotationchart rotationchart);
}
