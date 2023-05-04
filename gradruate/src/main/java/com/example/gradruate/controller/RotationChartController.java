package com.example.gradruate.controller;

import com.example.gradruate.commonutils.R;
import com.example.gradruate.entity.Rotationchart;
import com.example.gradruate.service.OssService;
import com.example.gradruate.service.RotationchartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/eduoss/rotation")
@CrossOrigin
public class RotationChartController {
    @Autowired
    private RotationchartService rotationchartService;
    @Autowired
    private OssService ossService;

    @PostMapping("/uploadRation")
    public R uploadRation( MultipartFile file){
//        System.out.println("进入");
        Map<String, String> map= rotationchartService.uploadRation(file);
//        System.out.println(map.toString()+"####@");
        return R.ok().data("url",map.get("url")).data("fileName",map.get("fileName"));

    }
//查询所有图片
    @PostMapping("/qureyAllPicture")
    public R qureyAllPicture( ){
//        System.out.println("进入");
        List<Rotationchart> map= rotationchartService.qureyAllPicture();

        return R.ok().data("map",map);

    }
    //删除轮播图
    //删除图片
    @GetMapping("/delpic/{bookname}")
    public R deleteOSSPictrueByName(@PathVariable("bookname") String pictrueName) {
        ossService.deleteOSSPictrueByName(pictrueName);
       int i=rotationchartService.del(pictrueName);
//        System.out.println("删除成功");
        return R.ok().data("ok","ok");

    }
    }
