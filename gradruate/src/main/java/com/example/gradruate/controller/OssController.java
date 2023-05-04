package com.example.gradruate.controller;


//import com.atguigu.oss.service.OssService;
import com.example.gradruate.commonutils.R;
import com.example.gradruate.service.OssService;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/eduoss/fileoss")
@CrossOrigin
public class OssController {

    @Autowired
    private OssService ossService;

    //上传头像的方法
    @PostMapping
    public R uploadOssFile(MultipartFile file) {
        //获取上传文件  MultipartFile
        //返回上传到oss的路径
//        System.out.println("上传封面");
        Map<String, String> map = ossService.uploadFileAvatar(file);

        return R.ok().data("url", map.get("url")).data("fileName",map.get("fileName"));
    }

    //删除图片
    @GetMapping("/delpic/{bookname}")
    public R deleteOSSPictrueByName(@PathVariable("bookname") String pictrueName) {

        ossService.deleteOSSPictrueByName(pictrueName);
       return R.ok().data("ok","删除成功");
    }
}
