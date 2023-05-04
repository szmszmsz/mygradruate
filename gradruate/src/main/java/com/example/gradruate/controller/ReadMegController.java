package com.example.gradruate.controller;

import cn.hutool.core.date.DateUtil;
import com.example.gradruate.commonutils.R;
import com.example.gradruate.entity.ReadMeg;
import com.example.gradruate.service.ReadMegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/readMeg")
@CrossOrigin
public class ReadMegController {
    @Autowired
    private ReadMegService readMegService;

    @PostMapping("/insertReadMeg")
    public R insertReadMeg(@RequestBody ReadMeg readMeg) {
        readMeg.setCreateTime( DateUtil.date());
        readMeg.setIsBackMeg("0");
        readMegService.insertReadMeg(readMeg);
        return R.ok().data("ok","ok");

    }

    @GetMapping("/queryBackReadMeg")
    public R queryBackReadMeg() {
        List<ReadMeg> readMegs = readMegService.queryBackReadMeg();
        for (ReadMeg readMeg:readMegs
             ) {

        }
        return R.ok().data("readMegs",readMegs);

    }

    @GetMapping("/updateReadMeg/{uid}")
    public R updateReadMeg(@PathVariable("uid") String uid) {
        readMegService.updateReadMeg(uid);
        return R.ok().data("ok",0);

    }
    //查询所有消息
    @GetMapping("/queryReadMeg/{uid}")
    public R queryReadMeg(@PathVariable("uid") String uid) {
       List<ReadMeg> readMeg= readMegService.queryReadMeg(uid);
       int unReadNum=readMegService.queryUnReadNum(uid);

        return R.ok().data("readMeg",readMeg);
    }
//    查询未读消息数目
        @GetMapping("/queryUnReadNum/{uid}")
        public R queryUnReadNum(@PathVariable("uid") String uid) {
            int unReadNum=readMegService.queryUnReadNum(uid);
            return R.ok().data("unReadNum",unReadNum);
        }
}
